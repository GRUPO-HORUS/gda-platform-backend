package com.horustek.gda.services.gestionalertas;

import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaBienTraza;
import com.horustek.gda.shared.dto.gestionbienes.GDABienDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBienTrazaService {

    /**
     * Almacenar la traza del evento de creacion de los bienes
     *
     * @param bien
     */
    void eventoCreacion(GdaBien bien);

    /**
     *
     * @param idBien Identificador del bien del cual se quiere conocer su traza
     * @param pageable Configuración del paginado
     * @return Listado paginado de las trazas de un bien
     */
    Page<GdaBienTraza> findAll(String idBien, Pageable pageable);

}
