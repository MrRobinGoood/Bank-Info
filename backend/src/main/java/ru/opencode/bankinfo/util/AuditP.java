package ru.opencode.bankinfo.util;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditP {
//    @CreatedBy
//    private Long createdByP;

    @CreatedDate
    private LocalDateTime createDateTimeP;

//    @LastModifiedBy
//    private Long changedByP;

    @LastModifiedDate
    private LocalDateTime changeDateTimeP;

    private Boolean isDeletedP = false;

}
