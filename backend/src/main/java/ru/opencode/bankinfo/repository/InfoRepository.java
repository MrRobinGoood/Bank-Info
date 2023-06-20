package ru.opencode.bankinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.opencode.bankinfo.entity.Info;
import ru.opencode.bankinfo.entity.Manual;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {

}
