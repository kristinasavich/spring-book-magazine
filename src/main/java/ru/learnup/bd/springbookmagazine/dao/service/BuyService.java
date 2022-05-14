package ru.learnup.bd.springbookmagazine.dao.service;

import org.springframework.stereotype.Service;
import ru.learnup.bd.springbookmagazine.dao.entity.Buy;
import ru.learnup.bd.springbookmagazine.dao.repository.BuyRepository;

import java.util.List;

@Service
public class BuyService {
    private final BuyRepository buyRepository;

    public BuyService(BuyRepository buyRepository) {
        this.buyRepository = buyRepository;
    }

    public List<Buy> getBuy(){
        return buyRepository.findAll();
    }

    public Buy createBuy(Buy buy){
        return buyRepository.save(buy);
    }

    public Buy getBuyById(Long id){
        return buyRepository.getById(id);
    }
}
