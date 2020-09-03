package com.horustek.gda.services.gestionbien.bien;

import com.horustek.gda.model.domain.GdaCategoriaBien;
import com.horustek.gda.shared.dto.gestionbienes.GdaCategoriaBienDTO;
import com.horustek.gda.shared.dto.gestionbienes.GdaCategoriaBienHijaDTO;
import com.horustek.gda.shared.dto.gestionbienes.GdaCategoriaBienPadreDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoriaBienService {

    /**
     * Obtener todos las categorias del sistema
     *
     * @param pageable : Configuration de paginación
     * @return Listado paginado de todos los usuarios
     */
    Page<GdaCategoriaBienDTO> findAll(Pageable pageable);

    /**
     * Obtener todos las categorias bases del sistema
     *
     * @param pageable : Configuration de paginación
     * @return Listado paginado de todos los usuarios
     */
    Page<GdaCategoriaBienPadreDTO> getCategoriaBase(Pageable pageable);

    /**
     * Obtener categorias hijas dado categoria padre
     *
     * @param pageable : Configuration de paginación
     * @return Listado paginado de todos los usuarios
     */
    Page<GdaCategoriaBienHijaDTO> getCategoriasHijas(String idCategoriaPadre, Pageable pageable);


}
