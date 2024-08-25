package com.lcwd.orm;

import com.lcwd.orm.entities.User;
import com.lcwd.orm.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ObjectRelationMappingApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    private Logger logger= LoggerFactory.getLogger(ObjectRelationMappingApplication.class);
    
    public static void main(String[] args) {
        
        SpringApplication.run(ObjectRelationMappingApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
//        User user = new User();
//        user.setName("sawan");
//        user.setCity("Patna");
//        user.setAge(34);
//        User savedUser = userService.saveUser(user);
//        System.out.println(savedUser);
        
        //get all user
//        List<User> users = userService.getAllUser();
//        logger.info("User size is {}",users.size());
//        logger.info("Users: {}",users);
        
        //get single user
//        User user = userService.getUser(2);
//        logger.info("User is {}",user);
        
        //update user
//        User user = new User();
//        user.setName("ankit tiwari");
//        user.setCity("Punjab");
//        user.setAge(32);
//        User updatedUser = userService.updateUser(user, 1);
//        logger.info("Updated User Details : {}",updatedUser);
        
        //delete user
        userService.deleteUser(1);
    }
}
