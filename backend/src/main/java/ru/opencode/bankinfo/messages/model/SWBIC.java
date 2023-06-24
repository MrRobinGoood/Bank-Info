package ru.opencode.bankinfo.messages.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SWBICS"/*, schema = "main"*/)
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class SWBIC {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Integer id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "entry_id", nullable = false)
    private Entry entry;

    @NonNull
    @Column(nullable = false)
    private String SWBIC;

    @NonNull
    @Column(nullable = false)
    private Boolean defaultSWBIC;

    private Boolean isDeleted = false;
}
