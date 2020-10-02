package com.horustek.gda.services.seguridad.usuario.impl;

import com.horustek.gda.infra.exceptions.BusinessException;
import com.horustek.gda.infra.exceptions.ErrorCodesEnum;
import com.horustek.gda.model.domain.GdaRol;
import com.horustek.gda.model.domain.GdaUsuario;
import com.horustek.gda.repositories.seguridad.RolRepository;
import com.horustek.gda.repositories.seguridad.UsuarioRepository;
import com.horustek.gda.services.seguridad.usuario.IRolService;
import com.horustek.gda.shared.dto.seguridad.GdaRolDTO;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import com.horustek.gda.shared.mapper.seguridad.GdaRolMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RolServiceImpl implements IRolService {

    private final RolRepository rolRepository;
    private final UsuarioRepository usuarioRepository;
    private final GdaRolMapper gdaRolMapper;

    public RolServiceImpl(RolRepository rolRepository, UsuarioRepository usuarioRepository, GdaRolMapper gdaRolMapper) {
        this.rolRepository = rolRepository;
        this.gdaRolMapper = gdaRolMapper;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Page<GdaRolDTO> findAll(Pageable pageable) {
        Page<GdaRol> rolPage = rolRepository.findAll(pageable);
        List<GdaRolDTO> list = gdaRolMapper
                .toGdaRolDTOs(rolPage.getContent());
        return new PageImpl<>(list, pageable, rolPage.getTotalElements());
    }

    @Override
    public List<GdaRolDTO> findAllUserRol(String idUsuario) {

        Optional<GdaUsuario> optionalGdaUsuario = usuarioRepository.findById(idUsuario);
        if(optionalGdaUsuario.isPresent()){

        }


        return null;
    }


    @Override
    @Transactional
    public void asignarRolesAUsuario(String idUsuario, List<GdaRol> listadoRoles) {

        Optional<GdaUsuario> optionalGdaUsuario = usuarioRepository.findById(idUsuario);
        if (optionalGdaUsuario.isPresent()) {
            // Si el usuario existe
            if (listadoRoles != null && !listadoRoles.isEmpty()) {
                //Si tiene roles a agregar , primero elimino todos los roles que tiene dado que no se si agregaron
                // o quitaron alguno de los que tienen
                eliminarRolesAUsuario(idUsuario);

                List<GdaRol> rolesAAsignar = new ArrayList<>();

                for (GdaRol rol:listadoRoles){
                    Optional<GdaRol> rolAAsignar = rolRepository.findById(rol.getId());
                    if(rolAAsignar.isPresent()){
                        rolesAAsignar.add(rolAAsignar.get());
                    }

                }

                if(!rolesAAsignar.isEmpty()){
                    // Asignar los nuevos roles al usuario
                    optionalGdaUsuario.get().setRoles(rolesAAsignar);
                    usuarioRepository.save(optionalGdaUsuario.get());
                }

            } else {
                throw new BusinessException(ErrorCodesEnum.GDA_ERR_13);
            }
        } else {
            throw new BusinessException(ErrorCodesEnum.GDA_ERR_12);
        }
    }

    @Override
    public void eliminarRolesAUsuario(String idUsuario) {

        Optional<GdaUsuario> optionalGdaUsuario = usuarioRepository.findById(idUsuario);
        if (optionalGdaUsuario.isPresent()) {
            int result = rolRepository.removeRolsToUserById(idUsuario);
        }
    }
}

