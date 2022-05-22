package ru.learnup.bd.springbookmagazine.dao.service;

import org.springframework.stereotype.Service;
import ru.learnup.bd.springbookmagazine.dao.controller.mapper.DetailsBuyViewMapper;
import ru.learnup.bd.springbookmagazine.dao.entity.Buy;
import ru.learnup.bd.springbookmagazine.dao.entity.Buyer;
import ru.learnup.bd.springbookmagazine.dao.entity.DetailsBuy;
import ru.learnup.bd.springbookmagazine.dao.repository.BuyRepository;
import ru.learnup.bd.springbookmagazine.dao.repository.BuyerRepository;
import ru.learnup.bd.springbookmagazine.dao.repository.DetailsBuyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetailsBuyService {

    private final DetailsBuyRepository detailsBuyRepository;
    private final BuyRepository buyRepository;

    public DetailsBuyService(DetailsBuyRepository detailsBuyRepository, BuyRepository buyRepository) {
        this.detailsBuyRepository = detailsBuyRepository;
        this.buyRepository = buyRepository;
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

    public DetailsBuy update(DetailsBuy detailsBuy){return detailsBuyRepository.save(detailsBuy);}

}
