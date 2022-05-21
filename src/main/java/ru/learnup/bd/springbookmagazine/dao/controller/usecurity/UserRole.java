package ru.learnup.bd.springbookmagazine.dao.controller.usecurity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class UserRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String role;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "roles"),
    inverseJoinColumns = @JoinColumn(name ="users_id"))
    private Set<User> users = new LinkedHashSet<>();

    public UserRole(String role) {
        this.role = role;
    }

    @Transient
    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(id, userRole.id) && Objects.equals(role, userRole.role) && Objects.equals(users, userRole.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, users);
    }
}
