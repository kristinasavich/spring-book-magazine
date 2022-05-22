package ru.learnup.bd.springbookmagazine.dao.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.learnup.bd.springbookmagazine.dao.controller.mapper.BuyViewMapper;
import ru.learnup.bd.springbookmagazine.dao.controller.usecurity.User;
import ru.learnup.bd.springbookmagazine.dao.controller.usecurity.UserService;
import ru.learnup.bd.springbookmagazine.dao.controller.view.BuyView;
import ru.learnup.bd.springbookmagazine.dao.entity.Buy;
import ru.learnup.bd.springbookmagazine.dao.entity.Buyer;
import ru.learnup.bd.springbookmagazine.dao.repository.BuyRepository;
import ru.learnup.bd.springbookmagazine.dao.repository.BuyerRepository;
import ru.learnup.bd.springbookmagazine.dao.service.BuyService;

import javax.persistence.EntityExistsException;

@RestController
@RequestMapping("api/v1/buy")
public class BuyController {
    private final UserService userService;
    private final BuyService buyService;
    private final BuyViewMapper buyViewMapper;
    private final BuyerRepository buyerRepository;
    private final BuyRepository buyRepository;

    public BuyController(UserService userService, BuyService buyService, BuyViewMapper buyViewMapper, BuyerRepository buyerRepository, BuyRepository buyRepository) {
        this.userService = userService;
        this.buyService = buyService;
        this.buyViewMapper = buyViewMapper;
        this.buyerRepository = buyerRepository;
        this.buyRepository = buyRepository;
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping
    public void getBuy(){
        User user = userService.loadUserByUsername(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName());

        if(user.getRoles().contains("ROLE_ADMIN")){
            buyRepository.findAll();
        } else if (user.getRoles().contains("ROLE_USER")) {
            Buyer buyer = buyerRepository.findAllByFullNameContains(user.getUsername());
            if(buyer.getFullName() != null) {
                buyRepository.findBuysByIdBuyer(buyer.getId());
            }
        }

    }

    @Secured({"ROLE_USER"})
    @PostMapping
    public BuyView createBuy(@RequestBody BuyView body){
        if(body.getIdBuy() != 0){
            throw new EntityExistsException("BUY exists!");
        }
        Buy buy = buyViewMapper.mapFromView(body);
        Buy serviceBuy = buyService.createBuy(buy);
        return buyViewMapper.mapToView(serviceBuy);
    }
}
