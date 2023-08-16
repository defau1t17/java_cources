package by.spring.dao;

import by.spring.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class JpaUserDao implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> select_user_from_user = entityManager.createNamedQuery("User.findAll", User.class);
        List<User> users = select_user_from_user.getResultList();
        return users;
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public void update(User user) {
        User user1 = entityManager.find(User.class, user);
        entityManager.merge(user1);
    }
}
