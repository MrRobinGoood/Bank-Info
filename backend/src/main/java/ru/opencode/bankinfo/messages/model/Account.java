package ru.opencode.bankinfo.messages.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Accounts"/*, schema = "main"*/)
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "entry_id", nullable = false)
    private Entry entry;

    @NonNull
    @Column(nullable = false)
    private String account;

    @NonNull
    @Column(nullable = false)
    private String regulationAccountType;

    @NonNull
    @Column(nullable = false)
    private Byte controlKey;

    @NonNull
    @Column(nullable = false)
    private String accountCBRBIC;

    @NonNull
    @Column(nullable = false)
    private LocalDate dateIn;

    private LocalDate dateOut;

    @NonNull
    @Column(nullable = false)
    private String accountStatus;

    private String AccRstr;

    private LocalDate AccRstrDate;

    private Boolean isDeleted = false;
}
