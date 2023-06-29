package ru.opencode.bankinfo.messages.entity.subClass;

import lombok.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Rstr {

    @NonNull
    private String rstr;

    @NonNull
    private LocalDate rstrDate;
}
