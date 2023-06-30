package ru.opencode.bankinfo.messages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.opencode.bankinfo.messages.entity.EMessageEntity;

public interface MessageRepository extends JpaRepository<EMessageEntity, Long> {
}
