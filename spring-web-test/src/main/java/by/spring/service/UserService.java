package by.spring.service;

import by.spring.dao.HibernateUserDao;
import by.spring.dao.JpaUserDao;
import by.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private JpaUserDao jpaUserDao;

    public void save(User user) {
        jpaUserDao.save(user);
        System.out.println(jpaUserDao.findAll());
    }



}
