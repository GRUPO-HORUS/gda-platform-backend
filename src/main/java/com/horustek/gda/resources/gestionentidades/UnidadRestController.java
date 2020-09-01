package com.horustek.gda.resources.gestionentidades;

import com.horustek.gda.services.gestionentidades.IGestionEntidadesService;
import com.horustek.gda.shared.dto.gestionEntidades.GdaTipoUnidadDTO;
import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadDTO;
import com.horustek.gda.shared.dto.seguridad.RegistroDTO;
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
    @RequestMapping("/gestionUnidades/unidad")
public class UnidadRestController {
    private final IGestionEntidadesService gestionEntidadesService;


    @GetMapping("/tipo")
    public ResponseEntity<?> listarTiposUnidades(@NotNull Pageable pageable) {
        Page<GdaTipoUnidadDTO> tipoUnidadDTOS = gestionEntidadesService.listarTipoUnidades(pageable);
        return new ResponseEntity<>(tipoUnidadDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> registrarUnidad(@Valid @RequestBody GdaUnidadDTO unidadDTO) {
        gestionEntidadesService.crearUnidad(unidadDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/tipo")
    public ResponseEntity<?> crearTipoUnidad(@RequestParam(name = "descripcion") String descripcion) {
        gestionEntidadesService.crearTipoUnidad(descripcion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
