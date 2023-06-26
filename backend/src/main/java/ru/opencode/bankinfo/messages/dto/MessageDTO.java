package ru.opencode.bankinfo.messages.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;
import ru.opencode.bankinfo.messages.entity.Entry;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class MessageDTO {

    @NonNull
    @NotNull
    private Integer id;

    @NonNull
    @NotNull
    @NotEmpty
    private Set<Entry> entries;

    @NonNull
    @NotNull
    private Long edNo;

    @NonNull
    @NotNull
    private LocalDate edDate;

    @NonNull
    @NotNull
    private Long edAuthor;

    @NonNull
    @NotNull
    @NotBlank
    private String creationReason;

    @NonNull
    @NotNull
    private LocalDateTime creationTime;

    @NonNull
    @NotNull
    @NotBlank
    private String infoTypeCode;

    @NonNull
    @NotNull
    private LocalDate businessDay;

    private Boolean isDeleted;
}
