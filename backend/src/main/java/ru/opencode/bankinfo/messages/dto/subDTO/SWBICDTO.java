package ru.opencode.bankinfo.messages.dto.subDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;
import ru.opencode.bankinfo.messages.entity.Entry;

@Data
public class SWBICDTO {

    @NonNull
    private Long id;

    @NonNull
    private Entry entry;

    @NonNull
    @NotBlank
    private String SWBIC;

    @NonNull
    private Boolean defaultSWBIC;

    private Boolean isDeleted;
}
