package ru.learnup.bd.springbookmagazine.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
public class Author {

    @Column
    private String fullName; //ФИО

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(fullName, author.fullName) && Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, id);
    }
}
