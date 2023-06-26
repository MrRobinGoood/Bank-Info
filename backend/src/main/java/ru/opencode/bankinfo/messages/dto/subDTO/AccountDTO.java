package ru.opencode.bankinfo.messages.dto.subDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class AccountDTO {

    @NonNull
    @NotNull
    private Integer id;

    @NonNull
    @NotNull
    @NotBlank
    private String account;

    @NonNull
    @NotNull
    @NotBlank
    private String regulationAccountType;

    @NonNull
    @NotNull
    private Byte controlKey;

    @NonNull
    @NotNull
    @NotBlank
    private String accountCBRBIC;

    @NonNull
    @NotNull
    @NotBlank
    private LocalDate dateIn;

    private LocalDate dateOut;

    @NonNull
    @NotNull
    @NotBlank
    private String accountStatus;

    private String AccRstr;

    private LocalDate AccRstrDate;

    private Boolean isDeleted;
}
