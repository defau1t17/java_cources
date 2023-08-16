package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserStorage {

    private final static List<User> users = new ArrayList<>();

    public void add_user(User user) {
        users.add(user);
    }

    public Optional<User> findByUserName(String user_name) {
        for (User u : users) {
            if (u.getUserName().equals(user_name))
                return Optional.of(u);
            }
        return Optional.empty();
    }

}
