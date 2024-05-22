package com.mybatis.controller;

import com.mybatis.model.User;
import com.mybatis.service.UserServices;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    private UserServices userServices;

    @PostMapping("/createTable")
    public ResponseEntity<String> createUserTable()
    {
        String response= userServices.createUserTable();
        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
    }

    @PostMapping("/registerUser")
    public ResponseEntity<String> createNewUser(@RequestBody User user)
    {
        String response= userServices.createNewUser(user);
        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("New User creation failed",HttpStatus.PRECONDITION_FAILED);

    }

    @PutMapping("/updateUserDetails")
    public ResponseEntity<String> updateUserInfo(@RequestBody User user)
    {
        String response=userServices.upadateUser(user);

        if (null!=response)
            return new ResponseEntity<>(response, HttpStatus.UPGRADE_REQUIRED);
        else
            return new ResponseEntity<>("User information's is failed",HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/AllUsers")
    public ResponseEntity<List<User>> getAllUserInfo()
    {
        List<User> users=userServices.allUsers();
                if(null!=users)
                    return new ResponseEntity<>(users,HttpStatus.OK);
                else
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable("id") Long id)
    {
        User user=userServices.getUserById(id);
        if(null!=user)
            return new ResponseEntity<>(user,HttpStatus.OK);
        else
            return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getUser/{userName}/{password}")
    public ResponseEntity<String> userLogin(@PathVariable("userName") String userName,
                                          @PathVariable("password") String password)
    {
        String response=userServices.loginUser(userName,password);
        if(null!=response)
            return new ResponseEntity<>(response,HttpStatus.OK);
        else
            return new ResponseEntity<>("Wrong username or passwod",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id)
    {
        String response=userServices.deleteUserById(id);
        if(null!=response)
            return new ResponseEntity<>(response,HttpStatus.OK);
        else
            return new ResponseEntity<>("User is not available",HttpStatus.NOT_FOUND);
    }
}
