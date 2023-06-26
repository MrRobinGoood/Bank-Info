package ru.opencode.bankinfo.manuals.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class InfoCreationDTO {
    @NotNull
    private String name;

}
