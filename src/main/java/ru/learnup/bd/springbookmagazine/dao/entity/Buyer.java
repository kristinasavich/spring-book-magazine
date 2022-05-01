package ru.learnup.bd.springbookmagazine.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fullName;


    private Long birthDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
