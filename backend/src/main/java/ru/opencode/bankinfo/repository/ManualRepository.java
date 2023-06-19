package ru.opencode.bankinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.opencode.bankinfo.entity.Manual;

import java.util.List;

@Repository
public interface ManualRepository extends JpaRepository<Manual, Long> {
    List<Manual> findByInfo_id (Long id);
}
