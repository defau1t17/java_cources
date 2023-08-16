package com.example.restapi.Controller;


import antlr.Token;
import com.example.restapi.Configuration.TokenProvider;
import com.example.restapi.Dao.UserInMemoryDao;
import com.example.restapi.Dao.UserRepository;
import com.example.restapi.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
//@Api(tags = {"Users"})
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInMemoryDao inMemoryDao;

    @Autowired
    private TokenProvider tokenProvider;


    @Autowired
    private UserRepository userRepository;

//    @ApiOperation(value = "save user into database", response = User.class)

    @PostMapping("/save")
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
        userRepository.save(user);
        //inMemoryDao.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //    @ApiOperation(value = "find all users from database")
    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(String username, String password) {
        Optional<User> byUsername = userRepository.findByUsername(username);
        if ((byUsername.isPresent())) {
            User user = byUsername.get();
            if (user.getPassword().equals(password)) {
                String s = tokenProvider.generateToken(user.getUsername());
                return ResponseEntity.ok(s);
            }

        }
        return ResponseEntity.badRequest().build();
    }

//    @ApiOperation(value = "find user by id number")

    @GetMapping("/id")
    public ResponseEntity<User> findById(long id) {

        if (id == 55) {
            throw new RuntimeException("bad ID");
        }

        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId.get());
        }
        return ResponseEntity.badRequest().build();
    }


    @GetMapping("/username")
    public User findByUserName(String username) {
        //Optional<User> byUserName = userRepository.findByUsername(username);
        Optional<User> byUserName = userRepository.findByUsername(username);
        if (byUserName.isPresent()) {
            return byUserName.get();
        }
        return null;
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        User save = userRepository.save(user);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody User user) {
        userRepository.delete(user);
        return ResponseEntity.badRequest().build();
    }


    @DeleteMapping("/id")
    public ResponseEntity<?> deleteById(long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
