package ru.learnup.bd.springbookmagazine.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Book {

    @Column
    private String name; //название книги

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long yearPublishing; // год издания

    @ManyToOne
    private Author author;

    @Column
    private Long numbPages;  //кол-во страниц

    @Column
    private Long sum; // стоимость


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Library library;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private DetailsBuy detailsBuy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
