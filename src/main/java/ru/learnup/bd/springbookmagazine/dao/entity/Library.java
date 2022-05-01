package ru.learnup.bd.springbookmagazine.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Library {

    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> book;

    @Column
    private Long lostBook; //остаток книг
    @Id
    private Long id;

}
