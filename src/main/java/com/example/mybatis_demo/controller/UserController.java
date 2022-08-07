package com.example.mybatis_demo.controller;

import com.example.mybatis_demo.entity.Role;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user")
    public User getUserById(@Param("id") long id) {
        return userService.getUserById(id);
    }

    @GetMapping("role")
    public Role getRoleById(@Param("id") long id) {
        return userService.getRoleById(id);
    }

    @GetMapping("role/all")
    public List<Role> getRoleByUId(@Param("id") long id) {
        return userService.getRoleByUId(id);
    }

    @GetMapping("user/all")
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("user/map")
    public Map<String, Object> getUserMap(@Param("id") long id) {
        return userService.getUserMap(id);
    }

    @GetMapping("user/set")
    public Set<User> getUserSet() {
        return userService.getUserSet();
    }

}
