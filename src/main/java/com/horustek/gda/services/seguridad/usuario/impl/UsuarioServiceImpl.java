package com.horustek.gda.services.seguridad.usuario.impl;

import com.horustek.gda.infra.exceptions.BusinessException;
import com.horustek.gda.infra.exceptions.ErrorCodesEnum;
import com.horustek.gda.infra.model.BaseSpecification;
import com.horustek.gda.infra.model.SearchCriteria;
import com.horustek.gda.infra.model.SearchOperation;
import com.horustek.gda.model.domain.GdaRol;
import com.horustek.gda.model.domain.GdaUsuario;
import com.horustek.gda.repositories.seguridad.RolRepository;
import com.horustek.gda.repositories.seguridad.UsuarioRepository;
import com.horustek.gda.services.seguridad.usuario.IUsuarioService;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import com.horustek.gda.shared.dto.seguridad.RegistroDTO;
import com.horustek.gda.shared.mapper.GdaUsuarioMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final GdaUsuarioMapper gdaUsuarioMapper;
    private final PasswordEncoder encoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Optional<GdaUsuario> gdaUsuarioOptional = usuarioRepository.findByNombreUsuarioIgnoreCase(usuario);

        if (!gdaUsuarioOptional.isPresent()) {
            gdaUsuarioOptional = usuarioRepository.findByEmailIgnoreCase(usuario);
            if (!gdaUsuarioOptional.isPresent()) {
                log.error("Login error : Don't exist '" + usuario + "' in the system!");
                throw new UsernameNotFoundException(
                        "Error en el login: no existe el usuario '" + usuario + "' en el sistema!");
            }
        }

        GdaUsuario usuarioBD = gdaUsuarioOptional.get();

        List<GrantedAuthority> authorities = usuarioBD.getRoles()
                .stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
                .collect(Collectors.toList());

        return new User(usuarioBD.getNombreUsuario(), usuarioBD.getCredencial(), usuarioBD.isEnabled(),
                true, true, true, authorities);
    }

    @Override
    public GdaUsuarioDTO findByUsername(String nombreUsuario) {
        Optional<GdaUsuario> gdaUsuario = usuarioRepository.findByNombreUsuarioIgnoreCase(nombreUsuario);
        return gdaUsuario.map(gdaUsuarioMapper::toGdaUsuarioDTO).orElse(null);
    }

    @Override
    public Page<GdaUsuarioDTO> findAll(Pageable pageable) {

        BaseSpecification<GdaUsuario> specification = new BaseSpecification<>();
        specification.add(new SearchCriteria("nombreUsuario", "alafourcade", SearchOperation.EQUAL));

        Page<GdaUsuario> usuarioPage = usuarioRepository.findAll(specification, pageable);
        List<GdaUsuarioDTO> list = gdaUsuarioMapper
                .toGdaUsuarioDTOs(usuarioPage.getContent());
        return new PageImpl<>(list, pageable, usuarioPage.getTotalElements());
    }

    @Override
    public GdaUsuarioDTO findById(String id) {
        Optional<GdaUsuario> gdaUsuario = usuarioRepository.findById(id);
        return gdaUsuario.map(gdaUsuarioMapper::toGdaUsuarioDTO).orElse(null);
    }

    @Transactional
    @Override
    public void register(@Valid RegistroDTO registroDTO) {
        if (usuarioRepository.existsByEmailIgnoreCase(registroDTO.getEmail())) {
            throw new BusinessException(ErrorCodesEnum.GDA_ERR_03, registroDTO.getEmail());
        }
        if (usuarioRepository.existsByNombreUsuarioIgnoreCase(registroDTO.getNombreUsuario())) {
            throw new BusinessException(ErrorCodesEnum.GDA_ERR_04, registroDTO.getNombreUsuario());
        }

        // Verificar todos los roles que se le quieren asignar al usuario
        List<GdaRol> rolesAAsignar = registroDTO.getRoles();
        List<GdaRol> systemRols = rolRepository.findAll();
        List<GdaRol> rolesAsignados = rolesAAsignar.stream()
                .filter(systemRols::contains).collect(Collectors.toList());

        if (rolesAsignados.isEmpty())
            throw new BusinessException(ErrorCodesEnum.GDA_ERR_05);


        // Crear una cuenta de usuario
        //El email siempre es almacenado con minúscula
        GdaUsuario nuevoUsuario = GdaUsuario.builder()
                .email(registroDTO.getEmail().toLowerCase())
                .nombreUsuario(registroDTO.getNombreUsuario())
                .credencial(encoder.encode(registroDTO.getCredencial()))
                .fechaCreacion(LocalDateTime.now())
                .enabled(true)
                .roles(rolesAsignados)
                .build();
        usuarioRepository.save(nuevoUsuario);
    }
}

