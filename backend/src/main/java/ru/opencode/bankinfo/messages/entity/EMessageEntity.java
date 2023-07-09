package ru.opencode.bankinfo.messages.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.opencode.bankinfo.core.utils.Audit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    private Long id;

    private String eMessageName;

    private List<Long> entriesId;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Long edNo;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private LocalDate edDate;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Long edAuthor;

    private Long edReceiver;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String creationReason;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private LocalDateTime creationTime;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String infoTypeCode;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private LocalDate businessDay;

    @Embedded
    private Audit auditFields;
}