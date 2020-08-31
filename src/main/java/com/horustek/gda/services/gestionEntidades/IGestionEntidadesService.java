package com.horustek.gda.services.gestionEntidades;

public interface IGestionEntidadesService {

    /**
     * Registrar una entidad en el sistema
     * @param nombre Nombre de la entidad
     */
    void crearEntidad(String nombre);

    /**
     * Registrar una tipo de unidad
     * @param nombre Nombre de la entidad
     */
    void crearTipoUnidad(String descripcion);
}
