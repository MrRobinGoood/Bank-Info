package ru.opencode.bankinfo.messages.entity.subClass;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ru.opencode.bankinfo.messages.entity.Entry;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Rstrs")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Rstr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @Setter(AccessLevel.PRIVATE)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "entry_idP", nullable = false)
    private Entry entry;

    @NonNull
    @NotNull
    @NotBlank
    private String rstr;

    @NonNull
    @NotNull
    private LocalDate rstrDate;

    public Rstr(Entry entry, @NonNull String rstr, @NonNull LocalDate rstrDate) {
        this.entry = entry;
        this.rstr = rstr;
        this.rstrDate = rstrDate;
    }
}
