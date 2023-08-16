package com.example.restapi.Dao;

import com.example.restapi.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserInMemoryDao {

    private final List<User> users = new ArrayList<>();
    private final AtomicLong id = new AtomicLong();


    public User save(User user) {
        user.setId(id.incrementAndGet());
        users.add(user);
        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }


    public Optional<User> findById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<User> findByUserName(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    public User update(User user) {
        return user;
    }

    public boolean delete(User user) {
        return  users.remove(user);
    }

    public Optional<User> deleteById(long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                User remove = users.remove(i);
                return Optional.of(remove);
            }
        }
        return Optional.empty();
    }
}
