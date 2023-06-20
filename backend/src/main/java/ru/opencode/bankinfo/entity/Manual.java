package ru.opencode.bankinfo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Data
@Table(name = "manuals")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Boolean isDeleted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "info_id")
    private Info info;

}
