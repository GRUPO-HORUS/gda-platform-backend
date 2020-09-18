package com.horustek.gda.resources.gestionbienes;

import com.horustek.gda.model.domain.GdaBienTraza;
import com.horustek.gda.services.gestionalertas.IBienTrazaService;
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
@RequestMapping("/alertas")
public class AlertasRestController {
    
    private final IBienTrazaService bienTrazaService;


    @GetMapping("/bien/{rotulado}")
    public ResponseEntity<?> getAllBienesTrazas(@PathVariable String rotulado, @NotNull Pageable pageable) {
        Page<GdaBienTraza> bienTrazas = bienTrazaService.findAll(rotulado, pageable);
        return new ResponseEntity<>(bienTrazas, HttpStatus.OK);
    }
}
