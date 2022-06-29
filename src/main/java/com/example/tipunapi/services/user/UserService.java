package com.example.tipunapi.services.user;

import com.example.tipunapi.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User login(String username, String password);
    User signup(User user);
    List<User> getAllUsers();
    User updateUser(User user);
    User findUserById(Long id);
    User favorite(User user);

    ResponseEntity<User> googleLogin(String googleAccessToken);
}
