package ru.learnup.bd.springbookmagazine.dao.service;

import ru.learnup.bd.springbookmagazine.dao.entity.Buyer;
import ru.learnup.bd.springbookmagazine.dao.entity.DetailsBuy;
import ru.learnup.bd.springbookmagazine.dao.repository.BuyerRepository;
import ru.learnup.bd.springbookmagazine.dao.repository.DetailsBuyRepository;

import java.util.List;

public class DetailsBuyService {

    private final DetailsBuyRepository detailsBuyRepository;

    public DetailsBuyService(DetailsBuyRepository detailsBuyRepository) {
        this.detailsBuyRepository = detailsBuyRepository;
    }

    public List<DetailsBuy> getDetailsBuy(){
        return detailsBuyRepository.findAll();
    }

    public DetailsBuy createDetailsBuy(DetailsBuy detailsBuy){
        return detailsBuyRepository.save(detailsBuy);
    }

    public DetailsBuy getDetailsBuyById(Long id){
        return detailsBuyRepository.getById(id);
    }
}
