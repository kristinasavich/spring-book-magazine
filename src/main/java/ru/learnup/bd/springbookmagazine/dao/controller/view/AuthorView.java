package ru.learnup.bd.springbookmagazine.dao.controller.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.learnup.bd.springbookmagazine.dao.entity.Book;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorView {
    private Long id;
    private String fullName; //ФИО
    private List<Book> book;
}
