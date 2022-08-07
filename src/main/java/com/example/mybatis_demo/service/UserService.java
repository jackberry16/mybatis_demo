package com.example.mybatis_demo.service;

import com.example.mybatis_demo.entity.Role;
import com.example.mybatis_demo.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {
    User getUserById(long id);

    Role getRoleById(long id);

    List<Role> getRoleByUId(long id);

    List<User> getUser();

    Map<String, Object> getUserMap(long id);

    String getUserMaps(long id);

    String getUserListMap();

    Set<User> getUserSet();
}
