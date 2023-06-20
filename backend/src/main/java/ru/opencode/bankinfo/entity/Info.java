package ru.opencode.bankinfo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "info")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
