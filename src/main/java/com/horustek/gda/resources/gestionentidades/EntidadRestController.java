package com.horustek.gda.resources.gestionentidades;

import com.horustek.gda.services.gestionentidades.IGestionEntidadesService;
import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/gestionEntidades/entidad")
public class EntidadRestController {

    private final IGestionEntidadesService gestionEntidadesService;


    @PostMapping
    public ResponseEntity<?> crearEntidad(@RequestParam(name = "nombre") String nombre) {
        gestionEntidadesService.crearEntidad(nombre);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/unidades")
    public ResponseEntity<?> listadoUnidades(@RequestParam(name = "nombre") String nombre) {
        List<GdaUnidadDTO> unidadDTOS = gestionEntidadesService.listadoUnidadesDadoNombreEntidad(nombre);
        return new ResponseEntity<>(unidadDTOS, HttpStatus.OK);
    }
}
