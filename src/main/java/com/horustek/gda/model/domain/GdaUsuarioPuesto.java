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
import javax.persistence.*;


@Entity
@Table(name = "gda_usuario_puesto")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaUsuarioPuesto.class)
public class GdaUsuarioPuesto extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_usuario_puesto")
    @GenericGenerator(name = "system-uuid-gda_usuario_puesto", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @JoinColumn(name = "gda_cargo_id", referencedColumnName = "id")
    @ManyToOne
    private GdaCargo gdaCargoId;
    @JoinColumn(name = "gda_unidad_id", referencedColumnName = "id")
    @ManyToOne
    private GdaUnidad gdaUnidadId;
    @JoinColumn(name = "gda_usuario_id", referencedColumnName = "id")
    @ManyToOne
    private GdaUsuario gdaUsuarioId;
}
