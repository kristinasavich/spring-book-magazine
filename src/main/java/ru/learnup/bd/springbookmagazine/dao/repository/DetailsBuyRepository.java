package ru.learnup.bd.springbookmagazine.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.learnup.bd.springbookmagazine.dao.entity.Buy;
import ru.learnup.bd.springbookmagazine.dao.entity.DetailsBuy;

import java.util.List;

public interface DetailsBuyRepository extends JpaRepository<DetailsBuy, Long> {
}
