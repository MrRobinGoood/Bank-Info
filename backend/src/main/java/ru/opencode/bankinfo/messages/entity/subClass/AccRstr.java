package ru.opencode.bankinfo.messages.entity.subClass;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class AccRstr extends Rstr {

    private Long SuccessorBIC;

    public AccRstr(@NonNull String rstr, @NonNull LocalDate rstrDate, Long successorBIC) {
        super(rstr, rstrDate);
        SuccessorBIC = successorBIC;
    }
}
