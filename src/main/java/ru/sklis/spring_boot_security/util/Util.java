package ru.sklis.spring_boot_security.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sklis.spring_boot_security.model.Role;
import ru.sklis.spring_boot_security.model.User;
import ru.sklis.spring_boot_security.service.RoleService;
import ru.sklis.spring_boot_security.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Set;


@Component
public class Util {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Util(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initDB() {
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");
        if (roleService.getAllUser().isEmpty()) {
            roleService.save(adminRole);
            roleService.save(userRole);
        }

        if (userService.findAll().isEmpty()) {
            userService.save(new User("Сергей", "1359", "admin@mail.ru", Set.of(adminRole)));
            userService.save(new User("Ольга", "1237", "user@mail.ru", Set.of(userRole)));
        }

    }
}
