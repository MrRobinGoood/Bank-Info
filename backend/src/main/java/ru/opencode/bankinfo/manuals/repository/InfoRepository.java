package ru.opencode.bankinfo.manuals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.opencode.bankinfo.manuals.entity.Info;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {

}
