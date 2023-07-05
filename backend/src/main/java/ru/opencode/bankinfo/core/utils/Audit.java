package ru.opencode.bankinfo.core.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Embeddable
@Data
public class Audit {

    private Boolean isDeleted = false;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Long createdBy;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private LocalDateTime createDateTime;

    private Long changeBy;

    private LocalDateTime changeDateTime;
}
