package com.example.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
public class BaseEntity extends BasicEntity {

    @LastModifiedBy
    @Column(name = "modifiedBy")
    String modifiedBy;

    @LastModifiedDate
    @Column(name = "modifiedAt")
    LocalDateTime modifiedAt;

    @Column(name = "deleted", columnDefinition = "TINYINT")
    boolean deleted = false;

    @PreUpdate
    public void preUpdate() {
        this.modifiedBy = "SYSTEM";
    }
}
