package ru.learnup.bd.springbookmagazine.dao.controller.mapper;

import org.springframework.stereotype.Component;
import ru.learnup.bd.springbookmagazine.dao.controller.view.BuyView;
import ru.learnup.bd.springbookmagazine.dao.entity.Buy;

@Component
public class BuyViewMapper {

    public BuyView mapToView(Buy buy){
        BuyView buyView = new BuyView();
        buyView.setIdBuy(buy.getBuyId());
        buyView.setSum(buy.getSum());
        buyView.setIdBuyer(buy.getIdBuyer());
        return buyView;
    }

    public Buy mapFromView(BuyView buyView){
        Buy buy = new Buy();
        buy.setBuyId(buyView.getIdBuy());
        buy.setIdBuyer(buyView.getIdBuyer());
        buy.setSum(buyView.getSum());
        return buy;
    }

}
