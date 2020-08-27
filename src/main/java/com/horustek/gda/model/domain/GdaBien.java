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
@Table(name = "gda_bien")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaBien.class)
public class GdaBien extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_bien")
    @GenericGenerator(name = "system-uuid-gda_bien", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "rotulado")
    private String rotulado;
    @Basic(optional = false)
    @Column(name = "fecha_incorporacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIncorporacion;
    @Basic(optional = false)
    @Column(name = "valor_incorporacion")
    private double valorIncorporacion;
    @Basic(optional = false)

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaBienId")
    private List<GdaBienTraza> gdaBienTrazaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaBienFijoId")
    private List<GdaBienFijoDatos> gdaBienFijoDatosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaBienFijoid")
    private List<GdaSolictudMovBienEspefico> gdaSolictudMovBienEspeficoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaBienPadreId")
    private List<GdaBien> gdaBienList;
    @JoinColumn(name = "gda_bien_padre_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaBien gdaBienPadreId;
    @JoinColumn(name = "gda_categoria_bien_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaCategoriaBien gdaCategoriaBienId;
    @JoinColumn(name = "gda_unidad_ubicacion_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaUnidad gdaUnidadUbicacionId;
    @JoinColumn(name = "gda_usuario_responsable_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaUsuario gdaUsuarioResponsableId;
}
