package ru.opencode.bankinfo.messages.entity.subClass;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.opencode.bankinfo.messages.entity.Account;
import ru.opencode.bankinfo.messages.entity.Participant;

import java.time.LocalDate;

@Entity
@Table(name = "AccRstrs")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AccRstr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    protected Long id;

    @NonNull
    @NotNull
    @NotBlank
    private String rstr;

    @NonNull
    @NotNull
    private LocalDate rstrDate;

    private Long successorBIC;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public AccRstr(@NonNull String rstr, @NonNull LocalDate rstrDate, Long successorBIC, Account account) {
        this.rstr = rstr;
        this.rstrDate = rstrDate;
        this.successorBIC = successorBIC;
        this.account = account;
    }
}
