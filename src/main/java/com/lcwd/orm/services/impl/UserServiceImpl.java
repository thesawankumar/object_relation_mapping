package com.lcwd.orm.services.impl;

import com.lcwd.orm.entities.User;
import com.lcwd.orm.repositories.UserRepository;
import com.lcwd.orm.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        logger.info("User saved: {}",savedUser.getId());
        return savedUser;
    }
    
    @Override
    public User updateUser(User user, int userId) {
        //user get database
        User user1 = userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("User with given id not found "));
        user1.setName(user.getName());
        user1.setCity(user.getCity());
        user1.setAge(user.getAge());
        
        //update user
        User updateUser = userRepository.save(user1);
        return updateUser;
    }
    
    @Override
    public void deleteUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with this id not found"));
        userRepository.delete(user);
        logger.info("User Deleted");
    }
    
    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }
    //get single user with given id
    @Override
    public User getUser(int userId) {
        Optional<User> byId = userRepository.findById(userId);
        User user = byId.orElseThrow(() -> new RuntimeException("User with given id not found"));
        return user;
    }
}
