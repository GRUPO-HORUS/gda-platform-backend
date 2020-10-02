package com.horustek.gda.services.gestionentidades;

import com.horustek.gda.shared.dto.gestionEntidades.*;
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
     * @param nombreEntidad Nombre de la entidad de la cual se desea conocer sus unidades
     */
    List<GdaUnidadBienResponseDTO> listadoUnidadesDadoNombreEntidad(String nombreEntidad);

    /**
     *  Este método se encarga de asignar a un listado de entidades, una unidad padre
     * @param unidadPadreDTO Unidad que fungira como la padre
     * @param unidades listado de unidades hijas
     */
    void asignarUnidadPadreAListadoDeUnidades(GdaUnidadRequestDTO unidadPadreDTO, List<GdaUnidadRequestDTO> unidades);

    /**
     * Crear una unidad
     * @param unidadDTO Objeto con los datos de la unidad a insertar
     */
    void crearUnidad(GdaUnidadRequestDTO unidadDTO);

    /**
     * Listado de unidades padres de una entidad
     * @param nombreEntidad Nombre de la entidad de la cual se desea conocer sus unidades padres
     */
    List<GdaUnidadPadreDTO> listadoUnidadesPadresDadoNombreEntidad(String nombreEntidad);

    /**
     * Listado de unidades hijas de una Entidad en particular dado el id de una unidad Padre de dicha Entidad
     * @param idUnidadPadre
     * @return
     */
    List<GdaUnidadHijaDTO> listadoUnidadesHijasDadoUnidadPadre(String nombreEntidad, String idUnidadPadre);
}
