package ru.learnup.bd.springbookmagazine.dao.controller.mapper;

import org.springframework.stereotype.Component;
import ru.learnup.bd.springbookmagazine.dao.controller.view.DetailsBuyView;
import ru.learnup.bd.springbookmagazine.dao.entity.DetailsBuy;

@Component
public class DetailsBuyViewMapper {

public DetailsBuyView mapToView(DetailsBuy detailsBuy){
    DetailsBuyView getDetailsBuy = new DetailsBuyView();
    getDetailsBuy.setIdBuy(detailsBuy.getIdBuy());
    getDetailsBuy.setBook(detailsBuy.getBook());
    getDetailsBuy.setAmountBook(detailsBuy.getAmountBook());
    getDetailsBuy.setId(getDetailsBuy.getId());
    return getDetailsBuy;
}

public DetailsBuy mapFromView(DetailsBuyView detailsBuyView){
    DetailsBuy detailsBuy = new DetailsBuy();
    detailsBuy.setAmountBook(detailsBuyView.getAmountBook());
    detailsBuy.setBook(detailsBuy.getBook());
    detailsBuy.setId(detailsBuy.getId());
    detailsBuy.setIdBuy(detailsBuy.getIdBuy());
    return detailsBuy;
}


}
