package ru.opencode.bankinfo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.opencode.bankinfo.entity.Info;

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
