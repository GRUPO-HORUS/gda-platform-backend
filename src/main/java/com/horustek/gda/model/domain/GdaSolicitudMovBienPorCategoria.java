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
@Table(name = "gda_solicitud_mov_bien_por_categoria")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaBien.class)
public class GdaSolicitudMovBienPorCategoria extends Auditable {

    @Id
    @Column(name = "gda_solicitud_mov_bien_id")
    private String id;

    @Basic(optional = false)
    @Column(name = "gda_solicitud_mov_biengda_origen_movimientoid")
    private String gdaSolicitudMovBiengdaOrigenMovimientoid;
    @Basic(optional = false)

    @JoinColumn(name = "gda_categoria_bien_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaCategoriaBien gdaCategoriaBienId;


      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name = "gda_solicitud_mov_bien_id")
      @MapsId
      private GdaSolicitudMovBien gdaSolicitudMovBien;




}
