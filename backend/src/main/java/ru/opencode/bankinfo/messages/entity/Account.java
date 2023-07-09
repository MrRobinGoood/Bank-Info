package ru.opencode.bankinfo.messages.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.opencode.bankinfo.core.utils.Audit;
import ru.opencode.bankinfo.messages.subClass.AccRstr;
import ru.opencode.bankinfo.messages.subClass.RstrList;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Accounts"/*, schema = "main"*/)
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Account {

    public Account(Entry entry, String account, String regulationAccountType, Long accountCBRBIC, LocalDate dateIn) {
        this.entry = entry;
        this.account = account;
        this.regulationAccountType = regulationAccountType;
        this.accountCBRBIC = accountCBRBIC;
        this.dateIn = dateIn;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    //    @NonNull
//    @NotNull
//    @JsonIgnore
//    @ToString.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "entry_id", nullable = false)
    private Entry entry;

    //    @NonNull
//    @NotNull
//    @NotBlank
//    @Column(nullable = false)
    private String account;

    //    @NonNull
//    @NotNull
//    @NotBlank
//    @Column(nullable = false)
    private String regulationAccountType;

    private Byte controlKey;

    //    @NonNull
//    @NotNull
//    @NotBlank
//    @Column(nullable = false)
    private Long accountCBRBIC;

    //    @NonNull
//    @NotNull
//    @Column(nullable = false)
    private LocalDate dateIn;

    private LocalDate dateOut;

    private String accountStatus;
    @Column(length = 1024)
    private RstrList accRstrList;

    @Embedded
    private Audit auditFields;
}
