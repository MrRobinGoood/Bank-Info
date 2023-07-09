package ru.opencode.bankinfo.messages.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.opencode.bankinfo.messages.entity.subClass.RstrList;

import ru.opencode.bankinfo.util.AuditP;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Participant extends AuditP {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Long idP;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String nameP;
    
    private String regN;

    private String cntrCd;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Integer rgn;

    private Integer ind;

    private String tnp;

    private String nnp;

    private String adr;

    private String prntBic;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private LocalDate dateIn;

    private LocalDate dateOut;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Byte ptType;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Byte srvcs;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Byte xchType;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String UID;

    private String participantStatus;
    @Column(length = 500)
    private RstrList rstrList;

}
