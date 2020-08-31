package com.horustek.gda.resources.gestionEntidades;

import com.horustek.gda.services.gestionEntidades.IGestionEntidadesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/gestionEntidades/unidad")
public class UnidadRestController {
    private final IGestionEntidadesService gestionEntidadesService;

    @PostMapping("/tipo")
    public ResponseEntity<?> crearTipoUnidad(@RequestParam(name = "descripcion") String descripcion) {
        gestionEntidadesService.crearTipoUnidad(descripcion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
