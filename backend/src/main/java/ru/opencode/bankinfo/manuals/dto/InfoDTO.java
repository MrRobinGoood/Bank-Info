package ru.opencode.bankinfo.manuals.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class InfoDTO {

    private Long id;
    @NotNull
    private String name;
    private LocalDateTime cTime;
    private String cUser;
    private LocalDateTime eTime;
    private String eUser;
    private Boolean isDeleted;
}
