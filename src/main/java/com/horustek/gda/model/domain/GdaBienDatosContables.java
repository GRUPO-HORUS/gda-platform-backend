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
@Table(name = "gda_bien_datos_contables")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaBienDatosContables.class)
public class GdaBienDatosContables extends Auditable {
    @Id
    @GeneratedValue(generator = "system-uuid-gda_bien_datos_contables")
    @GenericGenerator(name = "system-uuid-gda_bien_datos_contables", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "anno")
    private int anno;
    @Column(name = "valor_revaluo")
    private Double valorRevaluo;
    @Basic(optional = false)
    @Column(name = "valor_depreciacion")
    private double valorDepreciacion;
    @Column(name = "valor_neto_fiscal")
    private Double valorNetoFiscal;
    @JoinColumn(name = "gda_bienid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaBien gdaBienid;
    @JoinColumn(name = "gda_coeficiente_depreciacion_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaCoeficienteDepreciacion gdaCoeficienteDepreciacionId;

}
