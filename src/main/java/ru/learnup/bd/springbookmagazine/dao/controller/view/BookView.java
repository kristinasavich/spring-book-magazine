package ru.learnup.bd.springbookmagazine.dao.controller.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookView {

    private String name;
    private Long id;
    private Long yearPublishing; // год издания
    private String author;
    private Long numbPages;  //кол-во страниц
    private Long sum; // стоимость
    private String imageUrl;
}
