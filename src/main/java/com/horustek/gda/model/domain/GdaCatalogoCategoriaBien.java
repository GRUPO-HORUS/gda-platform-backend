/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horustek.gda.model.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.horustek.gda.infra.auditoria.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Entidad Mapeada de la Base de Datos
 *
 * @author Alejandro Lafourcade
 * @version 1.0
 * date 08/2020
 * copyright Grupo Horus
 *
 */
@Entity
@Table(name = "gda_catalogo_categoria_bien")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaCatalogoCategoriaBien.class)
public class GdaCatalogoCategoriaBien extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_catologo_categoria_bien")
    @GenericGenerator(name = "system-uuid-gda_catologo_categoria_bien", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "gdaCatalogosCategoriaId")
    private List<GdaAtributoCategoriaBien> gdaAtributoCategoriaBienList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaCatalogosCategoriaId")
    private List<GdaValoresCatalogoCategoriaBien> gdaValoresCatalogoCategoriaBienList;

}
