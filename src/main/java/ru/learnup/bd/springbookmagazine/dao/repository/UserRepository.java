package ru.learnup.bd.springbookmagazine.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.bd.springbookmagazine.dao.controller.usecurity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String userName);

}
