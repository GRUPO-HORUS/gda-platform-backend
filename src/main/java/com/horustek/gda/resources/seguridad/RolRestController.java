package com.horustek.gda.resources.seguridad;

import com.horustek.gda.GdaApplication;
import com.horustek.gda.services.seguridad.usuario.IRolService;
import com.horustek.gda.services.seguridad.usuario.IUsuarioService;
import com.horustek.gda.shared.dto.seguridad.GdaRolDTO;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import com.horustek.gda.shared.dto.seguridad.RegistroDTO;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth/rol")
public class RolRestController {
    private final IRolService rolService;

    @GetMapping
    public ResponseEntity<?> getAllRoles(@NotNull Pageable pageable) {
        Page<GdaRolDTO> rolDTOS = rolService.findAll(pageable);
        return new ResponseEntity<>(rolDTOS, HttpStatus.OK);
    }

}
