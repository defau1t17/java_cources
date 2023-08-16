package by.spring.dao;


import by.spring.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HibernateUserDao implements UserDao {


//    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    public User findById(long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);

        session.close();
        return user;
    }

    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        List<User> allUsers = session.createNativeQuery("from User", User.class).list();
        session.close();
        return allUsers;
    }

    public void delete(User user) {
        Session session = sessionFactory.openSession();
        session.createQuery("delete from User where id = :id").setParameter("id", user.getId()).executeUpdate();
        //        session.delete(user);


        session.close();
    }

    public void update(User user) {
        Session session = sessionFactory.openSession();
        session.createQuery("update User set username = :un where id = :id").setParameter("un", user.getUsername()).setParameter("id", user.getId()).executeUpdate();
//        session.update(user);
        session.close();
    }


}
