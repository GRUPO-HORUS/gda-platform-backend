package com.horustek.gda.resources.gestionentidades;

import com.horustek.gda.services.gestionentidades.IGestionEntidadesService;
import com.horustek.gda.shared.dto.gestionEntidades.GdaTipoUnidadDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/gestionEntidades/unidad")
public class UnidadRestController {
    private final IGestionEntidadesService gestionEntidadesService;


    @GetMapping("/tipo")
    public ResponseEntity<?> listarTiposUnidades(@NotNull Pageable pageable) {
        Page<GdaTipoUnidadDTO> tipoUnidadDTOS = gestionEntidadesService.listarTipoUnidades(pageable);
        return new ResponseEntity<>(tipoUnidadDTOS, HttpStatus.OK);
    }

    @PostMapping("/tipo")
    public ResponseEntity<?> crearTipoUnidad(@RequestParam(name = "descripcion") String descripcion) {
        gestionEntidadesService.crearTipoUnidad(descripcion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
