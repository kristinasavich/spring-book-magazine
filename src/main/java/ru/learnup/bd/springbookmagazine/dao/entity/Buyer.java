package ru.learnup.bd.springbookmagazine.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @Column
    private Long birthDay;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Buy> buyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
