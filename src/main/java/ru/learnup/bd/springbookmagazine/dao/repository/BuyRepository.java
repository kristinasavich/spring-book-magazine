package ru.learnup.bd.springbookmagazine.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.bd.springbookmagazine.dao.entity.Buy;
import ru.learnup.bd.springbookmagazine.dao.entity.Buyer;

import java.util.List;

@Repository
public interface BuyRepository extends JpaRepository<Buy, Long> {

    List<Buy> findBuyByIdBuyer(Buyer id);
}
