package com.horustek.gda.resources.gestionbienes;

import com.horustek.gda.services.gestionbien.bien.IBienService;
import com.horustek.gda.services.seguridad.usuario.IUsuarioService;
import com.horustek.gda.shared.dto.gestionbienes.GDABienDTO;
import com.horustek.gda.shared.dto.gestionbienes.GDABienTipoDTO;
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
@RequestMapping("/bien")
public class BienRestController {
    private final IBienService bienService;

    @GetMapping
    public ResponseEntity<?> getAllBienes(@NotNull Pageable pageable) {
        Page<GDABienDTO> bienesDTOs = bienService.findAll(pageable);
        return new ResponseEntity<>(bienesDTOs, HttpStatus.OK);
    }

    @GetMapping("/tipos")
    public ResponseEntity<?> getAllTipos(@NotNull Pageable pageable) {
        Page<GDABienTipoDTO> bienesTipoDTOs = bienService.findAllTiposBienes(pageable);
        return new ResponseEntity<>(bienesTipoDTOs, HttpStatus.OK);
    }



//    @GetMapping("{id}")
//    public ResponseEntity<?> findById(@PathVariable String id) {
//        GdaUsuarioDTO dto = usuarioService.findById(id);
//        return new ResponseEntity<>(dto, HttpStatus.OK);
//    }


}
