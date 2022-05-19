package ru.learnup.bd.springbookmagazine.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class Buy {

    @JsonIgnore
    @ManyToOne
    private Buyer idBuyer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrders;

    @Column
    private Long sum;
}
