package ru.opencode.bankinfo.manuals.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "manuals")
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Manual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String description;
    @Column(name = "c_time")
    private LocalDateTime cTime;
    @Column(name = "c_user")
    private Long cUser;
    @Column(name = "e_time")
    private LocalDateTime eTime;
    @Column(name = "e_user")
    private Long eUser;
    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private Boolean isDeleted = false;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "info_id")
    private Info info;

}
