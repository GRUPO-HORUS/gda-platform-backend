package com.horustek.gda.resources.seguridad;

import com.horustek.gda.services.seguridad.usuario.UsuarioService;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import com.horustek.gda.shared.dto.seguridad.RegistroDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth/usuarios")
public class UsuarioRestController {
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> getAllUsers(@NotNull Pageable pageable) {
        Page<GdaUsuarioDTO> usuariosDTOS = usuarioService.findAll(pageable);
        return new ResponseEntity<>(usuariosDTOS, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> findByUsername(@PathVariable String username) {
        GdaUsuarioDTO dto = usuarioService.findByUsername(username);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        GdaUsuarioDTO dto = usuarioService.findById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistroDTO registroDTO) {
        usuarioService.register(registroDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
