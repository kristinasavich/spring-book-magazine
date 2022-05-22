package ru.learnup.bd.springbookmagazine.dao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.learnup.bd.springbookmagazine.dao.controller.mapper.DetailsBuyViewMapper;
import ru.learnup.bd.springbookmagazine.dao.controller.usecurity.User;
import ru.learnup.bd.springbookmagazine.dao.controller.usecurity.UserService;
import ru.learnup.bd.springbookmagazine.dao.controller.view.DetailsBuyView;
import ru.learnup.bd.springbookmagazine.dao.entity.Book;
import ru.learnup.bd.springbookmagazine.dao.entity.Buyer;
import ru.learnup.bd.springbookmagazine.dao.entity.DetailsBuy;
import ru.learnup.bd.springbookmagazine.dao.repository.BuyRepository;
import ru.learnup.bd.springbookmagazine.dao.repository.BuyerRepository;
import ru.learnup.bd.springbookmagazine.dao.service.DetailsBuyService;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/v1/detailsbuy")
public class DetailsBuyController {
    private final DetailsBuyService detailsBuyService;
    private final UserService userService;
    private final DetailsBuyViewMapper detailsBuyViewMapper;
    private final BuyerRepository buyerRepository;
    private final BuyRepository buyRepository;

    public DetailsBuyController(DetailsBuyService detailsBuyService, UserService userService, DetailsBuyViewMapper detailsBuyViewMapper, BuyerRepository buyerRepository, BuyRepository buyRepository) {
        this.detailsBuyService = detailsBuyService;
        this.userService = userService;
        this.detailsBuyViewMapper = detailsBuyViewMapper;
        this.buyerRepository = buyerRepository;
        this.buyRepository = buyRepository;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping
    public DetailsBuyView getDetailsBuy(@RequestBody DetailsBuyView body){
        DetailsBuy detailsBuyById = detailsBuyService.getDetailsBuyById(body.getIdBuy().getBuyId());
        return detailsBuyViewMapper.mapToView(detailsBuyById);
    }

    @Secured({"ROLE_USER"})
    @PutMapping("/{buyid}")
    public DetailsBuyView setDetailsBuy(@PathVariable("buyid") Long buyid,
                                        @RequestBody DetailsBuyView  body){
        User user = userService.loadUserByUsername(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName());

        if (body.getId() == null) {
            throw new EntityNotFoundException("Try to found null entity");
        }
        if (!Objects.equals(buyid, body.getId())) {
            throw new RuntimeException("Entity has bad id");
        }

        Buyer buyer = buyerRepository.findAllByFullNameContains(user.getUsername());
        if(buyer.getFullName() != null) {
            buyRepository.findBuysByIdBuyer(buyer.getId());
        } else{
            throw new RuntimeException("You haven't made a purchase yet!");
        }

        DetailsBuy buy = detailsBuyService.getDetailsBuyById(buyid);
        if (buy.getAmountBook() != (body.getAmountBook())) {
            buy.setAmountBook(body.getAmountBook());
        }
        if (!buy.getBook().equals(body.getBook())) {
            buy.setBook(body.getBook());
        }

        DetailsBuy updated = detailsBuyService.update(buy);

        return detailsBuyViewMapper.mapToView(updated);

    }

    @Secured({"USER_ROLE"})
    @PostMapping
    public DetailsBuyView createDetails(@RequestBody DetailsBuyView body){
        if(body.getId() != 0){
            throw new EntityExistsException("Buy Details exists!");
        }
        DetailsBuy buy = detailsBuyViewMapper.mapFromView(body);
        DetailsBuy serviceBuy = detailsBuyService.createDetailsBuy(buy);
        return detailsBuyViewMapper.mapToView(serviceBuy);
    }
}
