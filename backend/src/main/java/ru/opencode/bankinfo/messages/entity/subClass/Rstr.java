package ru.opencode.bankinfo.messages.entity.subClass;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Rstr implements Serializable {

    @NonNull
    private String rstr;

    @NonNull
    private LocalDate rstrDate;
}
