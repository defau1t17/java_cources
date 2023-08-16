package postgres;

import utilities.User;

import java.util.Optional;

public interface UserDAO {

    public void save(User user);

    public Optional<User> findByUserName(String name);

}
