package com.example.springsecurity.Repository;

import com.example.springsecurity.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface userRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
