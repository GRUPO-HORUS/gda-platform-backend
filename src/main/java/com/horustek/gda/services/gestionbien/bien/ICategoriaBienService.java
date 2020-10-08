package com.horustek.gda.services.gestionbien.bien;

import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.GdaCategoriaBien;
import com.horustek.gda.shared.dto.gestionbienes.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

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

    /**
     * Obtener listado de detalle de los atributos que son necesarios para conformar el formulario de activos
     * @param idCategoria Identificador de la categoria de la cual se quieren conocer los atributos
     * @return Objeto DTO con el detalle
     */
    GdaDetalleAtributoCategoriaFormDTO obtenerLisobtenerListadoAtributosFormCategoria(String idCategoria);

    /**
     * Insertar los atributos dinamicos pertenecientes a las categorias
     * @param atributosDinamicos Listados de los atributos dinamicos que van a pertener al bien
     * @param bien Objeto bien que contendrá todos los atributos dinamicos
     */
    void insertarAtributosDinamicos(List<AtributoFormularioBienRequestDTO> atributosDinamicos, GdaBien bien);

}
