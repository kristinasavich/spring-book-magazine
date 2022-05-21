package ru.learnup.bd.springbookmagazine.dao.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learnup.bd.springbookmagazine.dao.controller.view.RoleView;
import ru.learnup.bd.springbookmagazine.dao.controller.view.UserView;
import ru.learnup.bd.springbookmagazine.dao.controller.usecurity.User;
import ru.learnup.bd.springbookmagazine.dao.controller.usecurity.UserRole;
import ru.learnup.bd.springbookmagazine.dao.controller.usecurity.UserService;

import javax.persistence.EntityExistsException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Boolean createUser(@RequestBody UserView user){
        if(user.getLogin() == null){
            throw new EntityExistsException("user null");
        }
        User getUser = new User();
        getUser.setUsername(user.getLogin());
        getUser.setPassword(user.getPassword());
        getUser.setRoles(user.getRoles()
                .stream()
                .map(RoleView::getRole)
                .map(UserRole::new)
                .collect(Collectors.toSet()));
        userService.create(getUser);
        return true;
    }

}
