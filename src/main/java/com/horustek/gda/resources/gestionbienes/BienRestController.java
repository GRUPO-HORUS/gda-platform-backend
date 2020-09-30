package com.horustek.gda.resources.gestionbienes;

import com.horustek.gda.services.gestionbien.bien.IBienService;
import com.horustek.gda.shared.dto.gestionbienes.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/bien")
public class BienRestController {
    private final IBienService bienService;

    @PostMapping
    public ResponseEntity<?> registrarBien(@RequestBody RegistroBienDTO registroBienDTO) {
        bienService.crearBien(registroBienDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

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

    @GetMapping("/detalle/{idBien}")
    public ResponseEntity<?> getDetalleBien(@PathVariable String idBien) {
        GdaDetalleBienDTO gdaDetalleBienDTOS = bienService.obtenerListadoAtributosBien(idBien);
        return new ResponseEntity<>(gdaDetalleBienDTOS, HttpStatus.OK);
    }

    @GetMapping("/asignaciones/{idBien}")
    public ResponseEntity<?> listadoAsignacionesBien(@PathVariable("idBien") String idBien, @NotNull Pageable pageable) {
        Page<GDABienAsignacionResponseDTO> asignacionDTOS = bienService.listadoAsignacionesDeUnBien(idBien, pageable);
        return new ResponseEntity<>(asignacionDTOS, HttpStatus.OK);
    }

    //TODO quitar este metodo que es solo para pruebas
    @GetMapping("/prueba/public")
    public ResponseEntity<?> prueba() {
        String prubea = bienService.crearRotuloBien();
        return new ResponseEntity<>(prubea, HttpStatus.OK);
    }


}
