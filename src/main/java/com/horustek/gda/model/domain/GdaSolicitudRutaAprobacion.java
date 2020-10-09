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
@Table(name = "gda_solicitud_ruta_aprobacion")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaSolicitudRutaAprobacion.class)
public class GdaSolicitudRutaAprobacion extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_solicitud_mov_ruta_aprobacion")
    @GenericGenerator(name = "system-uuid-gda_solicitud_mov_ruta_aprobacion", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
      @Basic(optional = false)
      @Column(name = "orden")
      private int orden;
      @JoinColumn(name = "gda_tipo_solicitud_id", referencedColumnName = "id")
      @ManyToOne(optional = false)
      private GdaTipoSolicitud gdaTipoSolicitudId;
      @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaSolicitudPasoAprobacionActual")
      private List<GdaSolicitud> gdaSolicitudList;
      @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaSolicitudRutaAprobacionId")
      private List<GdaSolicitudPasoRutaParticipantes> gdaSolicitudPasoRutaParticipantesList;
}
