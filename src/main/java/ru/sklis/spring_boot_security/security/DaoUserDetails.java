package ru.sklis.spring_boot_security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.sklis.spring_boot_security.model.User;
import ru.sklis.spring_boot_security.repository.UserRepository;


@Service
public class DaoUserDetails implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public DaoUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserPrincipal(user);
    }

}
