package ru.learnup.bd.springbookmagazine.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.bd.springbookmagazine.dao.controller.usecurity.UserRole;

import java.util.Set;

@Repository
public interface RolesRepository extends JpaRepository<UserRole, Long> {

    Set<UserRole> findByRoleIn(Set<String> roles);
}
