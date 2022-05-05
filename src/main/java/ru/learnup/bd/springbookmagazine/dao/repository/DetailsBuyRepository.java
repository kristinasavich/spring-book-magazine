package ru.learnup.bd.springbookmagazine.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.learnup.bd.springbookmagazine.dao.entity.DetailsBuy;

public interface DetailsBuyRepository extends JpaRepository<DetailsBuy, Long> {
}
