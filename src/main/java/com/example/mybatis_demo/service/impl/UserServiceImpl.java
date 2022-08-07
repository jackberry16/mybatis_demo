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
        map.keySet().forEach(a -> System.out.println(a + ":" + map.get(a)));
        return null;
    }

    @Override
    public String getUserMaps(long id) {
        Map<Long, User> map = userDao.getUserMaps(id);
        map.keySet().forEach(a -> System.out.println(a + ":" + map.get(a)));
        return null;
    }

    @Override
    public String getUserListMap() {
        List<Map<String, Object>> list = userDao.getUserListMap();
        for (Map<String,Object> map:list){
            map.keySet().forEach(a -> System.out.println(a + ":" + map.get(a)));
        }
        return null;
    }

    @Override
    public Set<User> getUserSet() {
        Set<User> set = userDao.getUserSet();
        set.forEach(a -> System.out.println(a.toString()));
        return null;
    }

    @Override
    public long addUser() {
        User user = new User();
        user.setUserName("addTest");
        user.setAddress("shanghai");
        userDao.addUser(user);
        return user.getId();
    }
}
