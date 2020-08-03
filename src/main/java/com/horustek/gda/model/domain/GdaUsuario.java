package com.horustek.gda.model.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.horustek.gda.infra.auditoria.Auditable;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "gda_usuarios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaUsuario.class)

public class GdaUsuario extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_rol")
    @GenericGenerator(name = "system-uuid-gda_rol", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;

    @Column(name = "nombre_usuario", unique = true, length = 20)
    private String nombreUsuario;

    @Column(name = "credencial", length = 60)
    private String credencial;

    private Boolean enabled;

    private String nombre;

    @Column(unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "gda_usuarios_roles", joinColumns = @JoinColumn(name = "gda_usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "gda_role_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"gda_usuario_id", "gda_role_id"})})
    private List<GdaRol> roles;

}