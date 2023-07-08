package ru.opencode.bankinfo.manuals.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ru.opencode.bankinfo.core.util.Audit;

import java.util.List;

@Table(name = "info")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Info extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Long id;
    @Column(nullable = false)
    private String name;
//    @Embedded
//    private Audit audit;

//    @Column(name = "is_deleted", columnDefinition = "boolean default false")
//    private Boolean isDeleted = false;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "info")
    private List<Manual> manuals;
}
