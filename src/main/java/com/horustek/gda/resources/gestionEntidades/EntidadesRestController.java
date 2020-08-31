package com.horustek.gda.resources.gestionEntidades;

import com.horustek.gda.services.gestionEntidades.IGestionEntidadesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/gestionEntidades/entidad")
public class EntidadesRestController {

    private final IGestionEntidadesService gestionEntidadesService;

    @PostMapping
    public ResponseEntity<?> crearEntidad(@RequestParam(name = "nombre") String nombre) {
        gestionEntidadesService.crearEntidad(nombre);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
