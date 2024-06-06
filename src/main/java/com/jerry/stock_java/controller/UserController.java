package com.jerry.stock_java.controller;

import com.jerry.stock_java.model.User;
import com.jerry.stock_java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
