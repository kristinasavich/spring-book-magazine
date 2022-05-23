package ru.learnup.bd.springbookmagazine.dao.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.learnup.bd.springbookmagazine.dao.entity.Book;
import ru.learnup.bd.springbookmagazine.dao.entity.Buyer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportView {
    private Long id;
    private Buyer buyer;
    private Long date;
    private List<Book> amountBook;
    private Long sum;
}
