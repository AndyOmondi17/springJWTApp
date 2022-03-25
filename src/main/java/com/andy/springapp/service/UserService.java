package com.andy.springapp.service;

import com.andy.springapp.model.Role;
import com.andy.springapp.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,  String roleName);
    User getUser(String username);
    List<User> getUsers();
}
