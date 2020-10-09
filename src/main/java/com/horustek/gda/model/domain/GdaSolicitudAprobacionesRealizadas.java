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
@Table(name = "gda_solicitud_aprobaciones_realizadas")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaSolicitudAprobacionesRealizadas.class)
public class GdaSolicitudAprobacionesRealizadas extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_solicitud_aprobaciones_realizadas")
    @GenericGenerator(name = "system-uuid-gda_solicitud_aprobaciones_realizadas", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @JoinColumn(name = "gda_solicitud_bien_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaSolicitud gdaSolicitudBienId;
    @JoinColumn(name = "gda_solicitud_paso_ruta_participantes_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaSolicitudPasoRutaParticipantes gdaSolicitudPasoRutaParticipantesId;
}
