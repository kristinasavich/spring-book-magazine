package ru.learnup.bd.springbookmagazine.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buy {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Buyer idBuyer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyId;

    @Column
    private Long sum;
}
