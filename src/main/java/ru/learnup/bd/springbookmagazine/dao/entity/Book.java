package ru.learnup.bd.springbookmagazine.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Book  {

    @Column
    private String name; //название книги

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long yearPublishing; // год издания

    @ManyToOne
    @ToString.Exclude
    private Author author;

    @Column
    private Long numbPages;  //кол-во страниц

    @Column
    private Long sum; // стоимость


//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Library library;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private DetailsBuy detailsBuy;

    public Book(String name, Long yearPublishing, Long numbPages, Long sum){
        this.yearPublishing = yearPublishing;
        this.numbPages = numbPages;
        this.name = name;
        this.sum = sum;
    }
}
