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

import java.util.Date;
import java.util.List;
import java.util.Objects;
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
@Table(name = "gda_roles")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaRol.class)
public class GdaRol extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_rol")
    @GenericGenerator(name = "system-uuid-gda_rol", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GdaRol gdaRol = (GdaRol) o;
        return id.trim().equals(gdaRol.id.trim());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

}
