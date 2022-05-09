package com.example.tipunapi.controllers;

import com.example.tipunapi.dto.UserLoginDTO;
import com.example.tipunapi.models.User;
import com.example.tipunapi.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public User login(@RequestBody UserLoginDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();

        return userService.login(username, password);
    }

    @PostMapping("/sign-up")
    public User signup(@Validated @RequestBody User user){
        return userService.signup(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }




}
