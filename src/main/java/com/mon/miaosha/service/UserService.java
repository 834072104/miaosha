package com.mon.miaosha.service;

import com.mon.miaosha.dao.UserDao;
import com.mon.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getById(Integer id){
        return userDao.getById(id);
    }

    @Transactional
    public boolean tx() {

        User user=new User();
        user.setId(5);
        user.setName("5555");
        userDao.tx(user);

//        User user1=new User();
//        user1.setId(6);
//        user1.setName("6666");
//        userDao.tx(user1);
        return  true;
    }
}
