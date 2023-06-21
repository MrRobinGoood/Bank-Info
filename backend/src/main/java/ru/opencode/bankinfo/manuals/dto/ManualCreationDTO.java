package ru.opencode.bankinfo.manuals.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ManualCreationDTO {
    @NotNull
    private String code;
    @NotNull
    private String description;
}
