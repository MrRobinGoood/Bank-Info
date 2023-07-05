package ru.opencode.bankinfo.core.exception.util;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@EntityListeners(AuditingEntityListener.class)
@Embeddable
public class Audit {
    @CreatedBy
    private Long createdBy;

    @CreatedDate
    private LocalDateTime createDateTime;

    @LastModifiedBy
    private Long changedBy;

    @LastModifiedDate
    private LocalDateTime changeDateTime;

//    @Column(name = "is_deleted", columnDefinition = "boolean default false")
//    private Boolean isDeleted = false;
}