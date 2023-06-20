package ru.opencode.bankinfo.manuals.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "info")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "c_time")
    private LocalDateTime cTime;
    @Column(name = "c_user")
    private Long cUser;
    @Column(name = "e_time")
    private LocalDateTime eTime;
    @Column(name = "e_user")
    private Long eUser;
    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private Boolean isDeleted;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "info")
    private List<Manual> manuals;
}
