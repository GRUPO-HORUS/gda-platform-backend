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
@Table(name = "gda_solicitud_mov_ruta_aprobacion")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaSolicitudMovRutaAprobacion.class)
public class GdaSolicitudMovRutaAprobacion extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_solicitud_mov_ruta_aprobacion")
    @GenericGenerator(name = "system-uuid-gda_solicitud_mov_ruta_aprobacion", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "gda_solicitud_mov_biengda_origen_movimientoid")
    private String gdaSolicitudMovBiengdaOrigenMovimientoid;
    @Basic(optional = false)
    @JoinColumn(name = "gda_solicitud_mov_bien_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaSolicitudMovBien gdaSolicitudMovBienId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaSolicitudMovRutaAprobacionid")
    private List<GdaSolicitudMovPasoRuta> gdaSolicitudMovPasoRutaList;
}
