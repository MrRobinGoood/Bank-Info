package ru.opencode.bankinfo.messages.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.opencode.bankinfo.manuals.entity.Manual;
import ru.opencode.bankinfo.messages.entity.EMessageEntity;

import java.time.LocalDateTime;

public interface MessageRepository extends JpaRepository<EMessageEntity, Long> {

    Page<EMessageEntity> findAllByeMessageNameContainsAndCreateDateTimeGreaterThanEqualAndCreateDateTimeLessThanEqual(String eMessageName, LocalDateTime localDateTimeStart, LocalDateTime localDateTimeEnd, Pageable pageable);


}
