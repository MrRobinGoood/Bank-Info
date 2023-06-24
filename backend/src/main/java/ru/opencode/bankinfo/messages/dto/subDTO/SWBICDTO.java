package ru.opencode.bankinfo.messages.dto.subDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;
import ru.opencode.bankinfo.messages.entity.Entry;

@Data
public class SWBICDTO {
    
    @NonNull
    @NotNull
    private Integer id;

    @NonNull
    @NotNull
    private Entry entry;

    @NonNull
    @NotNull
    @NotBlank
    private String SWBIC;

    @NonNull
    @NotNull
    private Boolean defaultSWBIC;

    private Boolean isDeleted;
}
