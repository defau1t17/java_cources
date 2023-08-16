package by.spring.dao;

import by.spring.entity.User;

import java.util.List;

public interface UserDao  {
    public void save(User user);

    public User findById(long id);

    public List<User> findAll();

    public void delete(User user);

    public void update(User user);

}
