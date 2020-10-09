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
@Table(name = "gda_solicitud")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaSolicitud.class)
public class GdaSolicitud extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_solicitud_mov_bien")
    @GenericGenerator(name = "system-uuid-gda_solicitud_mov_bien", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @Column(name = "estado_aprobacion_solicitud")
    private String estadoAprobacionSolicitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaSolicitudId")
    private List<GdaSolictudBienEspefico> gdaSolictudBienEspeficoList;
    @JoinColumn(name = "gda_origen_movimiento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaOrigenMovimiento gdaOrigenMovimientoId;
    @JoinColumn(name = "gda_solicitud_paso_aprobacion_actual", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaSolicitudRutaAprobacion gdaSolicitudPasoAprobacionActual;
    @JoinColumn(name = "gda_tipo_solicitud_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaTipoSolicitud gdaTipoSolicitudId;
    @JoinColumn(name = "gda_unidad_receptora_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaUnidad gdaUnidadReceptoraId;
    @JoinColumn(name = "gda_unidad_remitente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaUnidad gdaUnidadRemitenteId;
    @JoinColumn(name = "gda_usuario_creador_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaUsuario gdaUsuarioCreadorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaSolicitudBienId")
    private List<GdaSolicitudBienPorCategoria> gdaSolicitudBienPorCategoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaSolicitudBienId")
    private List<GdaSolicitudAprobacionesRealizadas> gdaSolicitudAprobacionesRealizadasList;
}
