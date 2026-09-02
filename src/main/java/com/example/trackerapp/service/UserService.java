package com.example.trackerapp.service;

import com.example.trackerapp.entity.User;
import com.example.trackerapp.entity.UserRole;
import com.example.trackerapp.repository.UserRepository;
import com.example.trackerapp.security.UserDetailsImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements UserDetailsService {
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

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("User not found with login: " + login));
        return UserDetailsImpl.build(user);
    }
//    public boolean checkPassword(String password){
//
//    }
}
