package ru.learnup.bd.springbookmagazine.dao.controller.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.learnup.bd.springbookmagazine.dao.entity.Book;
import ru.learnup.bd.springbookmagazine.dao.entity.Buy;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailsBuyView {
    private Long id; //IDEA потребовала
    private Buy idBuy;
    private List<Book> book;
    private long amountBook; //кол-во книг
    private Long sum;
}
