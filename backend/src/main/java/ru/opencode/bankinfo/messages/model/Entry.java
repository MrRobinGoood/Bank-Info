package ru.opencode.bankinfo.messages.model;

import jakarta.persistence.*;
import lombok.*;

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
    private Integer id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "message_id", nullable = false)
    private EMessageEntity message;

    @NonNull
    @Column(nullable = false)
    private String BIC;

    @NonNull
    @Embedded
    @Column(nullable = false)
    private Participant participant;

    @OneToMany(mappedBy = "entry", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<SWBIC> swbics;

    @OneToMany(mappedBy = "entry", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Account> accounts;

    private Boolean isDeleted = false;
}
