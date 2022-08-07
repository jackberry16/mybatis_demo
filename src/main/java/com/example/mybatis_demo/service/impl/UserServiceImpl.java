package com.example.mybatis_demo.service.impl;

import com.example.mybatis_demo.dao.UserDao;
import com.example.mybatis_demo.entity.Role;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public Role getRoleById(long id) {
        return userDao.getRoleById(id);
    }

    @Override
    public List<Role> getRoleByUId(long id) {
        return userDao.getRole(id);
    }

    @Override
    public List<User> getUser() {
        return userDao.getUser();
    }

    @Override
    public Map<String, Object> getUserMap(long id) {
        Map<String, Object> map = userDao.getUserMap(id);
        map.keySet().forEach(a -> System.out.println(a + ":" + String.valueOf(map.get(a))));
        return null;
    }

    @Override
    public Set<User> getUserSet() {
        Set<User> set = userDao.getUserSet();
        set.forEach(a -> System.out.println(a.toString()));
        return null;
    }
}
