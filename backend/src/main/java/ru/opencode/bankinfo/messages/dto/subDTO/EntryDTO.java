package ru.opencode.bankinfo.messages.dto.subDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
public class EntryDTO {
    
    @NonNull
    @NotNull
    private Integer id;
    
    @NonNull
    @NotNull
    @NotBlank
    private String BIC;

    @NonNull
    @NotNull
    private Integer idP;

    @NonNull
    @NotNull
    @NotBlank
    private String nameP;

    @NonNull
    @NotNull
    @NotBlank
    private String cntrCd;

    @NonNull
    @NotNull
    private Integer rgn;

    @NonNull
    @NotNull
    private Integer ind;

    @NonNull
    @NotNull
    @NotBlank
    private String tnp;

    @NonNull
    @NotNull
    @NotBlank
    private String nnp;

    @NonNull
    @NotNull
    @NotBlank
    private String adr;

    private String prntBic;

    @NonNull
    @NotNull
    private LocalDate dateIn;

    private LocalDate dateOut;

    @NonNull
    @NotNull
    private Byte ptType;

    @NonNull
    @NotNull
    private Byte srvcs;

    @NonNull
    @NotNull
    private Byte xchType;

    @NonNull
    @NotNull
    @NotBlank
    private String UID;

    @NonNull
    @NotNull
    @NotBlank
    private String participantStatus;

    private String rstr;

    private LocalDate rstrDate;

    private Boolean isDeletedP;
    
    private Set<SWBICDTO> swbics;
    
    private Set<AccountDTO> accounts;

    private Boolean isDeleted;
}
