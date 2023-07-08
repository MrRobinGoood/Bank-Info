package ru.opencode.bankinfo.messages.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.opencode.bankinfo.messages.subClass.Rstr;
import ru.opencode.bankinfo.messages.subClass.RstrList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Embeddable
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Participant {

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

    private RstrList rstrList;

    private Boolean isDeletedP = false;

//    @NonNull
//    @NotNull
//    @Column(nullable = false)
    private Long createdByP;

//    @NonNull
//    @NotNull
//    @Column(nullable = false)
    private LocalDateTime createDateTimeP;

    private Long changeByP;

    private LocalDateTime changeDateTimeP;
}
