package com.horustek.gda.infra.audit;

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
