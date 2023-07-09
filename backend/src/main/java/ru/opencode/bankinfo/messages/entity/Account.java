package ru.opencode.bankinfo.messages.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.opencode.bankinfo.util.Audit;
import ru.opencode.bankinfo.messages.entity.subClass.RstrList;

import java.time.LocalDate;

@Entity
@Table(name = "Accounts"/*, schema = "main"*/)
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Account extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @NonNull
    @NotNull
    @JsonIgnore
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
    @Column(nullable = false)
    private Long accountCBRBIC;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private LocalDate dateIn;

    private LocalDate dateOut;

    private String accountStatus;
    @Column(length = 500)
    private RstrList accRstrList;

}
