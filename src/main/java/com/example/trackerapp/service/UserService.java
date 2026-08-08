package com.example.trackerapp.service;

import com.example.trackerapp.entity.User;
import com.example.trackerapp.entity.UserRole;
import com.example.trackerapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(User user){
        userRepository.save(user);
    }
    public boolean existsUserByLogin(String login){
        return userRepository.existsUserByLogin(login);
    }
    public User createNewUser(String login, String password, UserRole role){
        return new User(login,passwordEncoder.encode(password),role);
    }
    public boolean checkPassword(String password){

    }
}
