package com.example.tipunapi.services.user;

import com.example.tipunapi.models.User;
import com.example.tipunapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;



    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null){
            if(password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @Override
    public User signup(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

}
