package ru.learnup.bd.springbookmagazine.dao.controller.usecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.learnup.bd.springbookmagazine.dao.repository.RolesRepository;
import ru.learnup.bd.springbookmagazine.dao.repository.UserRepository;

import javax.management.relation.Role;
import javax.persistence.EntityExistsException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    private PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, RolesRepository rolesRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public void create(User user){
        User username = userRepository.findByUsername(user.getUsername());
        if(username != null){
            throw new EntityExistsException("login already exists");
        }
        String password1 = user.getPassword();
        String password = passwordEncoder.encode(password1);
        user.setPassword(password);
        Set<String> setRoles = user.getRoles().stream()
                .map(UserRole::getRole)
                .collect(Collectors.toSet());
        Set<UserRole> userRoles = rolesRepository.findByRoleIn(setRoles);
        user.setRoles(userRoles);
        userRepository.save(user);
    }

    public void addRole(User user, Role role){

    }
}
