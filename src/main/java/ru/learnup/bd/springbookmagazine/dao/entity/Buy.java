package ru.learnup.bd.springbookmagazine.dao.entity;

import javax.persistence.*;

@Entity
@Table
public class Buy {

    @ManyToOne
    private Buyer idBuyer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrders;

    @Column
    private Long sum;
}
