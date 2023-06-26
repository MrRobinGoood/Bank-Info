package ru.opencode.bankinfo.messages.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Embeddable
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Participant {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Integer idP;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String nameP;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String cntrCd;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Integer rgn;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Integer ind;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String tnp;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String nnp;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
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

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String participantStatus;
    private String rstr;

    private LocalDate rstrDate;

    private Boolean isDeletedP = false;
}
