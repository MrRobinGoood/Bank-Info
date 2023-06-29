package ru.opencode.bankinfo.messages.dto.subDTO;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;
import ru.opencode.bankinfo.messages.entity.subClass.AccRstr;
import ru.opencode.bankinfo.messages.entity.subClass.Audit;

import java.time.LocalDate;
import java.util.List;

@Data
public class AccountDTO {

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

    @Embedded
    private Audit auditFields;
}
