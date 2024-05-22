package com.mybatis.service;

import com.mybatis.mapper.UserMapper;
import com.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServices{

    @Autowired
    private UserMapper userMapper;
    @Override
    public String createUserTable() {
        userMapper.createTable();

       return "User Table created Successfully";

    }

    @Override
    public String createNewUser(User user) {

        userMapper.insertUserInfo(user);

            return "New User Created Successfully";

    }

    @Override
    public String upadateUser(User user) {
        userMapper.updateUser(user);
        return "Successfully updated user information's";
    }

    @Override
    public List<User> allUsers() {
        return userMapper.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public String loginUser(String userName, String password) {
        User user=userMapper.findByUserNameAndPassword(userName,password);
        if(null!=user)
            return "Welcome back: "+user.getFirstName()+" "+user.getLastName();
        else
            return null;
    }

    @Override
    public String deleteUserById(Long id) {
        User user=getUserById(id);
        userMapper.deleteById(id);
        if(null!=user)
            return "User Deleted";
        else
            return null;
    }
}
