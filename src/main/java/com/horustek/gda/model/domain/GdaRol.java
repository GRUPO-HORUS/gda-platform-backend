package com.horustek.gda.model.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.horustek.gda.infra.auditoria.Auditable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "gda_roles")
@Getter
@SuperBuilder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaRol.class)
public class GdaRol extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_rol")
    @GenericGenerator(name = "system-uuid-gda_rol", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;

    @Column(unique = true, length = 20)
    private String nombre;

}
