/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.horustek.gda.model.domain;

import com.horustek.gda.infra.auditoria.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "gda_origen_movimiento")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GdaOrigenMovimiento extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_origen_movimiento")
    @GenericGenerator(name = "system-uuid-gda_origen_movimiento", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaOrigenMovimientoId")
    private List<GdaSolicitud> gdaSolicitudList;

}
