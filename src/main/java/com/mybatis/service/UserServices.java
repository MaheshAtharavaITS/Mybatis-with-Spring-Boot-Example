package com.mybatis.service;

import com.mybatis.model.User;

import java.util.List;

public interface UserServices {

    String createUserTable();

    String createNewUser(User user);

    String upadateUser(User user);

    List<User> allUsers();

    User getUserById(Long id);

    String loginUser(String userName, String password);

    String deleteUserById(Long id);
}
