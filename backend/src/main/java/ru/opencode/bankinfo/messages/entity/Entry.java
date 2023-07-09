package ru.opencode.bankinfo.messages.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.opencode.bankinfo.util.Audit;

import java.util.List;

@Entity
@Table(name = "Entries"/*, schema = "main"*/)
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Entry extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @NonNull
    @NotNull
    @Column(nullable = false)
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
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "entry", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<SWBIC> swbics;
    @JsonIgnore

    @OneToMany(mappedBy = "entry", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Account> accounts;

}
