package ru.sklis.spring_boot_security.service;



import ru.sklis.spring_boot_security.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllUser();

    void save(Role role);

    Role showUserById(Long id);

}
