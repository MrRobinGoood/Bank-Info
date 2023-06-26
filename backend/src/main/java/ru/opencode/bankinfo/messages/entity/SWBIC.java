package ru.opencode.bankinfo.messages.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    @ManyToOne
    @JoinColumn(name = "entry_id", nullable = false)
    private Entry entry;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String SWBIC;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Boolean defaultSWBIC;

    private Boolean isDeleted = false;
}
