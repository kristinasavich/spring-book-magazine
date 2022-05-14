package ru.learnup.bd.springbookmagazine.dao.service;

import ru.learnup.bd.springbookmagazine.dao.entity.Book;
import ru.learnup.bd.springbookmagazine.dao.entity.Buyer;
import ru.learnup.bd.springbookmagazine.dao.repository.BuyerRepository;

import java.util.List;

public class BuyerService {
    private final BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public List<Buyer> getBuyers(){
        return buyerRepository.findAll();
    }

    public Buyer createBuyer(Buyer buyer){
        return buyerRepository.save(buyer);
    }

    public Buyer getBuyerById(Long id){
        return buyerRepository.getById(id);
    }
}
