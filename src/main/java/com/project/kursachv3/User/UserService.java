package com.project.kursachv3.User;


import com.project.kursachv3.Role.Role;
import com.project.kursachv3.Role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int PASSWORD_LENGTH = 12; // Длина пароля
    private static final int USERNAME_LENGTH = 8;
    private static final SecureRandom random = new SecureRandom();

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // Основные функции для получения данных из бд
    public List<User> getAllUsers() {
        return userRepository.findAll();

    }

    public User getUserById(long id) {
        return userRepository.getReferenceById(id);
    }

    // Дополнительные функции
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    public User generateUser() {
        User generated = new User();
        String username = UUID.randomUUID().toString().substring(0, USERNAME_LENGTH);
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = random.nextInt(ALPHABET.length());
            password.append(ALPHABET.charAt(index));
        }
        String randomPassword = password.toString();
        Role role = roleService.getRoleByRole("ROLE_USER");
        if (role == null) {
            throw new DataIntegrityViolationException("Ошибка при генерации пользователя: роль пользователя не была создана");
        }
        generated.setPassword(passwordEncoder().encode(randomPassword));
        generated.setRawPassword(randomPassword);
        generated.setUsername(username);
        generated.addRole(role);
        return generated;

    };
}
