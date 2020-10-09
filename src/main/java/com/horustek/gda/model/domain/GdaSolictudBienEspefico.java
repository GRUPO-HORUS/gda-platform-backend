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

/**
 * Entidad Mapeada de la Base de Datos
 *
 * @author Alejandro Lafourcade
 * @version 1.0
 * date 08/2020
 * copyright Grupo Horus
 */
@Entity
@Table(name = "gda_solictud_bien_espefico")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaSolictudBienEspefico.class)
public class GdaSolictudBienEspefico extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_solicitud_bien_especifico")
    @GenericGenerator(name = "system-uuid-gda_solicitud_bien_especifico", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @JoinColumn(name = "gda_bien_fijo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaBien gdaBienFijoId;
    @JoinColumn(name = "gda_solicitud_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaSolicitud gdaSolicitudId;
}
