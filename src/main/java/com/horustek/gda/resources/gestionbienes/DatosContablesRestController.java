package com.horustek.gda.resources.gestionbienes;

import com.horustek.gda.services.gestionbien.bien.IBienDatosContablesService;
import com.horustek.gda.services.gestionbien.bien.IBienService;
import com.horustek.gda.shared.dto.gestionbienes.GDABienDTO;
import com.horustek.gda.shared.dto.gestionbienes.GDABienTipoDTO;
import com.horustek.gda.shared.dto.gestionbienes.GdaDetalleBienDTO;
import com.horustek.gda.shared.dto.gestionbienes.RegistroBienDTO;
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
@RequestMapping("/bien/datoscontables")
public class DatosContablesRestController {
    private final IBienDatosContablesService datosContablesService;

    @PostMapping("/coeficiente/{valorCoeficiente}")
    public ResponseEntity<?> insertCoeficienteReevaluo(@PathVariable double valorCoeficiente) {
        datosContablesService.insertarCoeficienteRevaluo(valorCoeficiente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
