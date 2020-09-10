package com.horustek.gda.model.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.horustek.gda.infra.auditoria.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "gda_coeficiente_depreciacion")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaCoeficienteDepreciacion.class)
public class GdaCoeficienteDepreciacion extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_coeficiente_depreciacion")
    @GenericGenerator(name = "system-uuid-gda_coeficiente_depreciacion", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "anno")
    private int anno;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaCoeficienteDepreciacionId")
    private List<GdaBienDatosContables> gdaBienDatosContablesList;
}
