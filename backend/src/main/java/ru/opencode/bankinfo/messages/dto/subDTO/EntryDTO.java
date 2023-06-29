package ru.opencode.bankinfo.messages.dto.subDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.opencode.bankinfo.messages.entity.subClass.Rstr;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class EntryDTO {

    @NonNull
    private Long id;
    
    @NonNull
    @NotBlank
    private String BIC;

    private String changeType;

    @NonNull
    private Integer idP;

    @NonNull
    @NotBlank
    private String nameP;

    private String regN;

    private String cntrCd;

    @NonNull
    private Integer rgn;

    private Integer ind;

    private String tnp;

    private String nnp;

    private String adr;

    private String prntBic;

    @NonNull
    private LocalDate dateIn;

    private LocalDate dateOut;

    @NonNull
    private Byte ptType;

    @NonNull
    private Byte srvcs;

    @NonNull
    private Byte xchType;

    @NonNull
    @NotBlank
    private String UID;

    private String participantStatus;

    List<Rstr> rstrList;

    private Boolean isDeletedP;
    
    private Set<SWBICDTO> swbics;
    
    private Set<AccountDTO> accounts;

    private Boolean isDeleted;
}
