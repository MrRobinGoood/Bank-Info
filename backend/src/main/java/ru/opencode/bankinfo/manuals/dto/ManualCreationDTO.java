package ru.opencode.bankinfo.manuals.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class ManualCreationDTO {
    @NotNull
    @NonNull
    private String code;
    @NotNull
    @NonNull
    private String description;
}
