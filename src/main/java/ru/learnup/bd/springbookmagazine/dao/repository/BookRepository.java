package ru.learnup.bd.springbookmagazine.dao.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.learnup.bd.springbookmagazine.dao.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    //    @Query(value = "select * from book b left join author a on a.id = b.author_id where a.full_name = :name",
//            nativeQuery = true)
    @Query(value = "from Book b join fetch b.author where b.author.fullName = :name")
    List<Book> findAllByAuthorContains(String name);

    List<Book> findBookByNameContains(String name);

    List<Book> findAllByNameContains(String name);
    List<Book> findAllByNameOrAuthor(String name, String nameAuthor);

    List<Book> findAll(Specification<Book> specification);


}
