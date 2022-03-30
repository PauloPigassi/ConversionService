package com.example.demo.controller;

import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.UserTransaction;
import com.example.demo.model.to.UserRequestTO;
import com.example.demo.service.UserService;

/**
 * User endpoint controller
 * @author Paulo Pigassi
 */
@RestController
@RequestMapping("users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    /**
     * Default constructor
     * @param userService {@link com.paulopigassi.conversordemoedas.service.UserService} service object
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint to add user
     * @param userRequestTO {@link java.lang.String} user name request object
     * @return {@link org.springframework.http.ResponseEntity}
     */
    @PostMapping
    @Transactional
    public ResponseEntity<UserTransaction> save(
            @Valid
            @RequestBody UserRequestTO userRequestTO) {
        logger.info(String.format(
                "starting save user request with name: %s", userRequestTO.toString()));
        UserTransaction savedUser = (UserTransaction) userService.save(userRequestTO);

        logger.info(String.format("return save user request object: %s", savedUser.toString()));
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    /**
     * Endpoint to get all users
     * @return {@link org.springframework.http.ResponseEntity}
     */
    @GetMapping
    public ResponseEntity<?> getAllUsers( ) {
        logger.info("starting request for all users");

        List<com.example.demo.model.entity.UserTransaction> userList = userService.getAll();

        logger.info(String.format("return request for all users list: %s", userList.toString()));
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
    
  
}
