package ru.learnup.bd.springbookmagazine.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.learnup.bd.springbookmagazine.dao.report.Report;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Book  {

    @Column
    private String name; //название книги

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long yearPublishing; // год издания

    @JsonIgnore
    @ManyToOne
    @ToString.Exclude
    private Author author;

    @Column
    private Long numbPages;  //кол-во страниц

    @Column
    private Long sum; // стоимость


    private String imageUrl;


//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Library library;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private DetailsBuy detailsBuy;

    public Book(String name, Long yearPublishing, Long numbPages, Long sum, Author author){
        this.author = author;
        this.yearPublishing = yearPublishing;
        this.numbPages = numbPages;
        this.name = name;
        this.sum = sum;
    }
}
