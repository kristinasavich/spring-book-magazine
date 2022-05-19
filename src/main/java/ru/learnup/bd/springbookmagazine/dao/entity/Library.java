package ru.learnup.bd.springbookmagazine.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
//@ToString(exclude = {"book"})
@Getter
@Setter
public class Library {

    @Column
    private Long lostBook; //остаток книг

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne
    @JoinColumn
    @ToString.Exclude
    private Book book;

    public Library(Book book, Long lostBook){
        this.book = book;
        this.lostBook = lostBook;
    }
}
