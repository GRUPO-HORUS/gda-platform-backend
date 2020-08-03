package com.horustek.gda.infra.auditoria;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Clase base de la cual heredan todas aquellas entidades que contendrán una
 * Auditoría básica dentro de la solución
 *
 * @author Alejandro Lafourcade
 * @version 1.0
 * date 31/07/2020
 * copyright Grupo Horus
 *
 */

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements Serializable {
    @CreatedBy
    @Column(updatable = false)
    protected String creadoPor;

    @CreatedDate
    @Column(updatable = false)
    protected LocalDateTime fechaCreacion;

    @LastModifiedBy
    protected String modificadoPor;

    @LastModifiedDate
    protected LocalDateTime fechaModificacion;
}
