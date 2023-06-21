package ru.opencode.bankinfo.manuals.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InfoCreationDTO {
    @NotNull
    private String name;

}
