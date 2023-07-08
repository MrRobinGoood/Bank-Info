package ru.opencode.bankinfo.messages.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.opencode.bankinfo.core.utils.Audit;
import ru.opencode.bankinfo.messages.entity.subClass.RstrList;

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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "entry_id", nullable = false)
    private Entry entry;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String account;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String regulationAccountType;

    private Byte controlKey;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private Long accountCBRBIC;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private LocalDate dateIn;

    private LocalDate dateOut;

    private String accountStatus;

    private RstrList accRstrList;

    @Embedded
    private Audit auditFields;
}
