package ru.opencode.bankinfo.messages.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Embeddable
@Entity
@Table(name = "Participants"/*, schema = "main"*/)
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Integer id;

    @NonNull
    @Column(nullable = false)
    private String nameP;

    @NonNull
    @Column(nullable = false)
    private String cntrCd;

    @NonNull
    @Column(nullable = false)
    private Integer rgn;

    @NonNull
    @Column(nullable = false)
    private Integer ind;

    @NonNull
    @Column(nullable = false)
    private String tnp;

    @NonNull
    @Column(nullable = false)
    private String nnp;

    @NonNull
    @Column(nullable = false)
    private String adr;

    private String prntBic;

    @NonNull
    @Column(nullable = false)
    private LocalDate dateIn;

    private LocalDate dateOut;

    @NonNull
    @Column(nullable = false)
    private Byte ptType;

    @NonNull
    @Column(nullable = false)
    private Byte srvcs;

    @NonNull
    @Column(nullable = false)
    private Byte xchType;

    @NonNull
    @Column(nullable = false)
    private String UID;

    @NonNull
    @Column(nullable = false)
    private String participantStatus;

    private String rstr;

    private LocalDate rstrDate;

    private Boolean isDeleted = false;
}
