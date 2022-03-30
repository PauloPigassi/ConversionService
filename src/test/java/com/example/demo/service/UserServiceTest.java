package com.example.demo.service;


import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.UserTransaction;
import com.example.demo.model.to.UserRequestTO;
import com.example.demo.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveTest(){
        UserTransaction user = userService.save(new UserRequestTO("test"));
        Assertions.assertThat(user.getUserCode()).isNotNull();
        userRepository.delete(user);
    }

    @Test
    public void getAllTest(){
    	UserTransaction user = userService.save(new UserRequestTO("test"));
        List userList = userService.getAll();
        Assertions.assertThat(userList.size()).isEqualTo(1);
        userRepository.delete(user);
    }

}
