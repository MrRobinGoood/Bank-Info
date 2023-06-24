package ru.opencode.bankinfo.manuals.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ManualDTO {
    private Long id;
    @NotNull
    private String code;
    @NotNull
    private String description;
    private LocalDateTime cTime;
    private Long cUser;
    private LocalDateTime eTime;
    private Long eUser;
    private Boolean isDeleted;
}
