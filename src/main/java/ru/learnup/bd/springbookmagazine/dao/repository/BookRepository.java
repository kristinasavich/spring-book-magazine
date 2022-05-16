package ru.learnup.bd.springbookmagazine.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.learnup.bd.springbookmagazine.dao.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "from Book b join fetch b.author where b.author.fullName = :name")
    List<Book> findAllByAuthorContains(String name);
}
