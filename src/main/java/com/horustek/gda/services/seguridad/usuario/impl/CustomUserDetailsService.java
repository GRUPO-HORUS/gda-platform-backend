package com.horustek.gda.services.usuario.impl;

import com.horustek.gda.model.domain.GdaUsuario;
import com.horustek.gda.repositories.seguridad.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

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

        return new User(usuarioBD.getNombreUsuario(), usuarioBD.getCredencial(), usuarioBD.getEnabled(),
                true, true, true, authorities);
    }

}

