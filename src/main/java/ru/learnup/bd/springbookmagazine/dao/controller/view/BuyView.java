package ru.learnup.bd.springbookmagazine.dao.controller.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.learnup.bd.springbookmagazine.dao.entity.Buyer;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyView {
    private Buyer idBuyer;
    private Long idBuy;
    private Long sum;
}
