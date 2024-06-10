package com.jerry.stock_java.controller;

import com.jerry.stock_java.dto.UserNameRequest;
import com.jerry.stock_java.dto.UserPasswordRequest;
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

    @GetMapping("/users/{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable int user_id){
        User user = userService.getUserById(user_id);
        if(user != null){
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/users/{user_id}/username")
    public ResponseEntity<String> getUserNameById(@PathVariable int user_id){
        User user = userService.getUserById(user_id);
        String user_name = user.getUser_name();
        if(user_name != null){
            return ResponseEntity.status(HttpStatus.OK).body(user_name);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/users/{user_id}/password")
    public ResponseEntity<String> getUserPasswordById(@PathVariable int user_id){
        User user = userService.getUserById(user_id);
        String user_password = user.getUser_password();
        if(user_password != null){
            return ResponseEntity.status(HttpStatus.OK).body(user_password);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        int user_id_created = userService.createUser(user);
        if(user_id_created >= 1){
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/users/{user_id}")
    public ResponseEntity<User> updateUserName(@PathVariable int user_id, @RequestBody UserNameRequest userNameRequest) {
        String new_user_name = userNameRequest.getUser_name();
        userService.updateUserName(user_id, new_user_name);
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(user_id));
    }

    @PutMapping("/users/{user_id}")
    public ResponseEntity<User> updateUserPassword(@PathVariable int user_id, @RequestBody UserPasswordRequest userPasswordRequest) {
        String new_user_password = userPasswordRequest.getUser_password();
        userService.updateUserPassword(user_id, new_user_password);
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(user_id));
    }

    @DeleteMapping("/users/{user_id}")
    public ResponseEntity<?> deleteUser(@PathVariable int user_id){
        userService.deleteUser(user_id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
