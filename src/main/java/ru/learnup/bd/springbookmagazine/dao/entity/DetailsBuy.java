package ru.learnup.bd.springbookmagazine.dao.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class DetailsBuy implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //IDEA потребовала

    @MapsId
    @OneToOne
    @JoinColumn(name = "idorders")
    private Buy idOrders;

    @OneToMany(mappedBy = "detailsBuy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> book;

    @Column
    private long amountBook; //кол-во книг

    @Column
    private Long sum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailsBuy that = (DetailsBuy) o;
        return amountBook == that.amountBook && sum == that.sum && Objects.equals(idOrders, that.idOrders) && Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrders, book, amountBook, sum);
    }
}
