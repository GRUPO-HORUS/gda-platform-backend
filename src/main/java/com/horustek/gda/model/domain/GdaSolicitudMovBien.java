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
@Table(name = "gda_solicitud_mov_bien")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaSolicitudMovBien.class)
public class GdaSolicitudMovBien extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_solicitud_mov_bien")
    @GenericGenerator(name = "system-uuid-gda_solicitud_mov_bien", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "tipo_solicitud")
    private String tipoSolicitud;
    @Basic(optional = false)

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaSolicitudMovBienId")
    private List<GdaSolicitudMovRutaAprobacion> gdaSolicitudMovRutaAprobacionList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "gdaSolicitudMovBien")
    private GdaSolicitudMovBienPorCategoria gdaSolicitudMovBienPorCategoria;
    @JoinColumn(name = "gda_origen_movimiento_id", referencedColumnName = "id")
    @ManyToOne
    private GdaOrigenMovimiento gdaOrigenMovimientoId;
    @JoinColumn(name = "gda_solicitud_mov_paso_ruta_id", referencedColumnName = "id")
    @ManyToOne
    private GdaSolicitudMovPasoRuta gdaSolicitudMovPasoRutaId;
    @JoinColumn(name = "gda_usuario_creador_id", referencedColumnName = "id")
    @ManyToOne
    private GdaUsuario gdaUsuarioCreadorId;
    @JoinColumn(name = "gda_usuario_destinatario_id", referencedColumnName = "id")
    @ManyToOne
    private GdaUsuario gdaUsuarioDestinatarioId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "gdaSolicitudMovBien")
    private GdaSolictudMovBienEspefico gdaSolictudMovBienEspefico;


}
