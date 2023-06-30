package ru.opencode.bankinfo.messages.dto;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;
import ru.opencode.bankinfo.messages.dto.subDTO.EntryDTO;
import ru.opencode.bankinfo.messages.entity.Entry;
import ru.opencode.bankinfo.messages.entity.subClass.Audit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class MessageDTO {

    private String eMessageName;

    private Set<Long> entriesId;

    @NonNull
    private Long edNo;

    @NonNull
    private LocalDate edDate;

    @NonNull
    private Long edAuthor;

    private Long edReceiver;

    @NonNull
    @NotBlank
    private String creationReason;

    @NonNull
    private LocalDateTime creationTime;

    @NonNull
    @NotBlank
    private String infoTypeCode;

    @NonNull
    private LocalDate businessDay;

    @Embedded
    private Audit auditFields;
}
