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
 */
@Entity
@Table(name = "gda_unidad")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaUnidad.class)
public class GdaUnidad extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_unidad")
    @GenericGenerator(name = "system-uuid-gda_unidad", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @JoinColumn(name = "gda_entidad_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaEntidad gdaEntidadId;
    @JoinColumn(name = "gda_tipo_unidad_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaTipoUnidad gdaTipoUnidadId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaUnidadPadreId")
    private List<GdaUnidad> gdaUnidadList;
    @JoinColumn(name = "gda_unidad_padre_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaUnidad gdaUnidadPadreId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaUnidadId")
    private List<GdaUsuario> gdaUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaUnidadUbicacionId")
    private List<GdaBien> gdaBienList;

}
