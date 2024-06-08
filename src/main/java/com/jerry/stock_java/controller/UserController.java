package com.jerry.stock_java.controller;

import com.jerry.stock_java.dto.UserNameRequest;
import com.jerry.stock_java.model.User;
import com.jerry.stock_java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{user_name}")
    public ResponseEntity<User> getUserByName(@PathVariable String user_name){

        User user = userService.getUsersByName(user_name);

        if(user != null){
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/users/{user_name}/id")
    public int getUserIdByName(@PathVariable String user_name){return userService.getUserIdByName(user_name);}

    @GetMapping("/users/{user_name}/password")
    public String getUserPasswordByName(@PathVariable String user_name){return userService.getPasswordByName(user_name);}

    @PostMapping("/users")
    public int createUser(@RequestBody User user){return userService.createUser(user);}

    @PutMapping("/users/{user_name}")
    public int updateUserName(@PathVariable String user_name, @RequestBody UserNameRequest userNameRequest) {
        String new_user_name = userNameRequest.getUser_name();
        return userService.updateUserName(user_name, new_user_name);
    }
}
