package com.horustek.gda.resources.gestionbienes;

import com.horustek.gda.services.gestionbien.bien.ICategoriaBienService;
import com.horustek.gda.services.seguridad.usuario.IUsuarioService;
import com.horustek.gda.shared.dto.gestionbienes.GdaCategoriaBienDTO;
import com.horustek.gda.shared.dto.gestionbienes.GdaCategoriaBienHijaDTO;
import com.horustek.gda.shared.dto.gestionbienes.GdaCategoriaBienPadreDTO;
import com.horustek.gda.shared.dto.seguridad.GdaUsuarioDTO;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/categoria")
public class CategoriaRestController {

    private final ICategoriaBienService categoriaBienService;

    @GetMapping
    public ResponseEntity<?> getAllCategorias(@NotNull Pageable pageable) {
        Page<GdaCategoriaBienDTO> categoriaBienDTOS = categoriaBienService.findAll(pageable);
        return new ResponseEntity<>(categoriaBienDTOS, HttpStatus.OK);
    }

    @GetMapping("/base")
    public ResponseEntity<?> getAllCategoriasBase(@NotNull Pageable pageable) {
        Page<GdaCategoriaBienPadreDTO> categoriaBienBaseDTOS = categoriaBienService.getCategoriaBase(pageable);
        return new ResponseEntity<>(categoriaBienBaseDTOS, HttpStatus.OK);
    }

    @GetMapping("/hijas/{idPadre}")
    public ResponseEntity<?> getCategoriasHijasDadoIdPadre(@PathVariable String idPadre, @NotNull Pageable pageable) {
        Page<GdaCategoriaBienHijaDTO> categoriaBienHijaDTOS = categoriaBienService.getCategoriasHijas(idPadre, pageable);
        return new ResponseEntity<>(categoriaBienHijaDTOS, HttpStatus.OK);
    }
}
