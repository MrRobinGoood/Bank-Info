package ru.opencode.bankinfo.messages.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "EMessages"/*, schema = "main"*/)
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class EMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Integer id;

    @NonNull
    @OneToMany(mappedBy = "message", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Entry> entries;

    @NonNull
    @Column(nullable = false)
    private Long edNo;

    @NonNull
    @Column(nullable = false)
    private LocalDate edDate;

    @NonNull
    @Column(nullable = false)
    private Long edAuthor;

    @NonNull
    @Column(nullable = false)
    private String creationReason;

    @NonNull
    @Column(nullable = false)
    private LocalDateTime creationTime;

    @NonNull
    @Column(nullable = false)
    private String infoTypeCode;

    @NonNull
    @Column(nullable = false)
    private LocalDate businessDay;

    private Boolean isDeleted = false;
}
