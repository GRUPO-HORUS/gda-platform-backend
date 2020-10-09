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

import javax.persistence.*;
import java.util.List;

/**
 * Entidad Mapeada de la Base de Datos
 *
 * @author Alejandro Lafourcade
 * @version 1.0
 * date 08/2020
 * copyright Grupo Horus
 */
@Entity
@Table(name = "gda_solicitud_paso_ruta_participantes")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaSolicitudPasoRutaParticipantes.class)
public class GdaSolicitudPasoRutaParticipantes extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_solicitud_paso_ruta_participantes")
    @GenericGenerator(name = "system-uuid-gda_solicitud_paso_ruta_participantes", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaSolicitudPasoRutaParticipantesId")
    private List<GdaSolicitudAprobacionesRealizadas> gdaSolicitudAprobacionesRealizadasList;
    @JoinColumn(name = "gda_solicitud_ruta_aprobacion_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaSolicitudRutaAprobacion gdaSolicitudRutaAprobacionId;
    @JoinColumn(name = "gda_usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaUsuario gdaUsuarioId;
}
