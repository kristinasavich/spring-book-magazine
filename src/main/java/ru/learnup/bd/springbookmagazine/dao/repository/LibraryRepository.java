package ru.learnup.bd.springbookmagazine.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.bd.springbookmagazine.dao.entity.Library;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

    Library findAllByBookContains(String text);

}
