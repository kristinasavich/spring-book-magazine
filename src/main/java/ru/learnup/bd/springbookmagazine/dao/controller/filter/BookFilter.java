package ru.learnup.bd.springbookmagazine.dao.controller.filter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookFilter {
    private String name;
    private String author;
}
