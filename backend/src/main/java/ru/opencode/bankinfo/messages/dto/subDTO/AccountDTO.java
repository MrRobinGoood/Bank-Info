package ru.opencode.bankinfo.messages.dto.subDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;
import ru.opencode.bankinfo.messages.entity.subClass.AccRstr;

import java.time.LocalDate;
import java.util.List;

@Data
public class AccountDTO {

    @NonNull
    private Long id;

    @NonNull
    @NotBlank
    private String account;

    @NonNull
    @NotBlank
    private String regulationAccountType;

    private Byte controlKey;

    @NonNull
    @NotBlank
    private String accountCBRBIC;

    @NonNull
    @NotBlank
    private LocalDate dateIn;

    private LocalDate dateOut;

    private String accountStatus;

    private List<AccRstr> accRstrList;

    private Boolean isDeleted;
}
