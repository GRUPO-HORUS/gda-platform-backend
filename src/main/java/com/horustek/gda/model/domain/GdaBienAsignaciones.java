package com.horustek.gda.model.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.horustek.gda.infra.auditoria.Auditable;
import com.horustek.gda.model.domain.enumeradores.BienTipoAsignacionEnum;
import com.horustek.gda.model.domain.enumeradores.EstadoInactividadEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * Esta entidad representa las asignaciones. Una asignacion es la relacion establecida entre un usuario con rol responsable
 * y el tipo de responsabilidad que tiene dicho usuario con un Bien
 *
 * @author Alejandro Lafourcade
 * @version 1.0
 * date 08/2020
 * copyright Grupo Horus
 *
 */
@Entity
@Table(name = "gda_bien_asignaciones")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaBienAsignaciones.class)

public class GdaBienAsignaciones extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_bien_asignaciones")
    @GenericGenerator(name = "system-uuid-gda_bien_asignaciones", strategy = "uuid2")
    @Basic(optional = false)
    private String id;
    @Basic(optional = false)
    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoInactividadEnum estado;
    @Basic(optional = false)
    @Column(name = "tipo_asignacion")
    @Enumerated(EnumType.STRING)
    private BienTipoAsignacionEnum tipoAsignacion;
    @JoinColumn(name = "gda_bien_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaBien gdaBienId;
    @JoinColumn(name = "gda_usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaUsuario gdaUsuarioId;

}
