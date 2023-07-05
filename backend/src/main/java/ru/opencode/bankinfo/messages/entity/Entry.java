package ru.opencode.bankinfo.messages.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.opencode.bankinfo.core.utils.Audit;

import java.util.Set;

@Entity
@Table(name = "Entries"/*, schema = "main"*/)
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @NonNull
    @NotNull
    private Long messageId;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String BIC;

    private String changeType;

    @NonNull
    @NotNull
    @Embedded
    @Column(nullable = false)
    private Participant participant;

    @OneToMany(mappedBy = "entry", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<SWBIC> swbics;

    @OneToMany(mappedBy = "entry", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Account> accounts;

    @Embedded
    private Audit auditFields;
}
