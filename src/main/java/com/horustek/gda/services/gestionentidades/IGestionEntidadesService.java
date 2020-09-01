package com.horustek.gda.services.gestionentidades;

import com.horustek.gda.model.domain.GdaEntidad;
import com.horustek.gda.model.domain.GdaUnidad;
import com.horustek.gda.shared.dto.gestionEntidades.GdaTipoUnidadDTO;
import com.horustek.gda.shared.dto.gestionEntidades.GdaUnidadDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGestionEntidadesService {

    /**
     * Registrar una entidad en el sistema
     * @param nombre Nombre de la entidad
     */
    void crearEntidad(String nombre);

    /**
     * Listar los tipos de entidades del sistema
     */
    Page<GdaTipoUnidadDTO> listarTipoUnidades(Pageable pageable);

    /**
     * Registrar una tipo de unidad
     * @param nombre Nombre de la entidad
     */
    void crearTipoUnidad(String descripcion);

    /**
     * Listado de unidades de una entidad
     * @param nombre Nombre de la entidad de la cual se desea conocer sus unidades
     */
    List<GdaUnidadDTO> listadoUnidadesDadoNombreEntidad(String nombreEntidad);

    /**
     * Este método se encarga de asignar a un listado de entidades, una unidad padre
     * @param nombre Nombre de la entidad de la cual se desea conocer sus unidades
     */
    void asignarUnidadPadreAListadoDeUnidades(GdaUnidadDTO unidadPadreDTO, List<GdaUnidadDTO> unidades);

    /**
     * Crear una unidad
     * @param unidadDTO Objeto con los datos de la unidad a insertar
     */
    void crearUnidad(GdaUnidadDTO unidadDTO);
}
