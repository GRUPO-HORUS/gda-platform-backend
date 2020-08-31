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
import javax.persistence.*;

/**
 * Entidad Mapeada de la Base de Datos
 * Esta entidad representa al usuario de la aplicación, el cual tiene varias funciones como por ejemplo
 * responsabilizarse  por los bienes de una entidad, acceso al sistema, control de los bienes etc
 *
 * @author Alejandro Lafourcade
 * @version 1.0
 * date 08/2020
 * copyright Grupo Horus
 */
@Entity
@Table(name = "gda_usuario")
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = GdaUsuario.class)
public class GdaUsuario extends Auditable {

    @Id
    @GeneratedValue(generator = "system-uuid-gda_usuario")
    @GenericGenerator(name = "system-uuid-gda_usuario", strategy = "uuid2")
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "nombreusuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @Column(name = "credencial")
    private String credencial;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @Column(name = "enabled")
    private boolean enabled;
    @Basic(optional = false)

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(name = "gda_usuario_roles", joinColumns = @JoinColumn(name = "gda_usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "gda_roles_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"gda_usuario_id", "gda_roles_id"})})
    private List<GdaRol> roles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaUsuarioId")
    private List<GdaSolicitudMovPasoRutaParticipantes> gdaSolicitudMovPasoRutaParticipantesList;
    @JoinColumn(name = "gda_unidad_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GdaUnidad gdaUnidadId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaUsuarioCreadorId")
    private List<GdaSolicitudMovBien> gdaSolicitudMovBienList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaUsuarioDestinatarioId")
    private List<GdaSolicitudMovBien> gdaSolicitudMovBienList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gdaUsuarioResponsableId")
    private List<GdaBien> gdaBienList;

}
