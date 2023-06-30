package ru.opencode.bankinfo.messages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.opencode.bankinfo.messages.entity.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
