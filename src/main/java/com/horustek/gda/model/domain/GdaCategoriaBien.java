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
@Table(name = "gda_categoria_bien")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaCategoriaBien.class)
public class GdaCategoriaBien extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_categoria_bien")
    @GenericGenerator(name = "system-uuid-gda_categoria_bien", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaCategoriaBienId")
    private List<GdaAtributoCategoriaBien> gdaAtributoCategoriaBienList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaCategoriaBienId")
    private List<GdaCategoriaBien> gdaCategoriaBienList;
    @JoinColumn(name = "gda_categoria_bien_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaCategoriaBien gdaCategoriaBienId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaCategoriaBienId")
    private List<GdaSolicitudMovBienPorCategoria> gdaSolicitudMovBienPorCategoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaCategoriaBienId")
    private List<GdaBien> gdaBienList;

}
