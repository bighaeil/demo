package com.example.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BasicEntity implements Serializable {
    @CreatedBy
    @Column(name = "createdBy")
    String createdBy;

    @CreatedDate
    @Column(name = "createdAt")
    LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdBy = "SYSTEM";
    }

}
