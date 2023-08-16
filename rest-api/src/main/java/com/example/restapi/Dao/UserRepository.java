package com.example.restapi.Dao;

import com.example.restapi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


//@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

//    @Query(value = "select u from User u where u.username = :username")
//    Optional<User> myFindByUserName(@Param("username") String username);


}
