package com.example.trackerapp.repository;

import com.example.trackerapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByLogin(String login);
}
