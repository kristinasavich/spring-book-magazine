package ru.learnup.bd.springbookmagazine.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.bd.springbookmagazine.dao.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

    List<Author> findAllByFullNameContains(String name);

}
