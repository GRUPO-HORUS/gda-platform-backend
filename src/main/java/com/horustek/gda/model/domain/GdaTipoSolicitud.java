package com.horustek.gda.model.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.horustek.gda.infra.auditoria.Auditable;
import com.horustek.gda.model.domain.enumeradores.BienEstadoEnum;
import com.horustek.gda.model.domain.enumeradores.TipoSolicitudEnum;
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
@Table(name = "gda_tipo_solicitud")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaTipoSolicitud.class)
public class GdaTipoSolicitud extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_tipo_solicitud")
    @GenericGenerator(name = "system-uuid-gda_tipo_solicitud", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "tipo_solicitud")
    @Enumerated(EnumType.STRING)
    private TipoSolicitudEnum tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaTipoSolicitudId")
    private List<GdaSolicitudRutaAprobacion> gdaSolicitudRutaAprobacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaTipoSolicitudId")
    private List<GdaSolicitud> gdaSolicitudList;


}
