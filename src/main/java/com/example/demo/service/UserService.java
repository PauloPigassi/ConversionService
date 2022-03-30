package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.UserTransaction;
import com.example.demo.model.to.UserRequestTO;
import com.example.demo.repository.UserRepository;

/**
 * Service class for management of User request object and to access repository
 * @author Paulo Pigassi
 */
@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(CurrencyConverterService.class);

    private UserRepository userRepository;

    /**
     * Default constructor
     * @param userRepository user repository object
     */
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * Save user object
     * @param userRequestTO {@link com.paulopigassi.conversordemoedas.model.to.UserRequestTO} user request object
     * @return {@link com.paulopigassi.conversordemoedas.model.entity.User}
     */
    public UserTransaction save(UserRequestTO userRequestTO) {
    	UserTransaction user = new UserTransaction(userRequestTO.getName());
        logger.info(String.format("User object to save: %s", user));
        return this.userRepository.save(user);
    }

    /**
     * Get all users
     * @return {@link java.util.List}
     */
    public List<UserTransaction> getAll() {
        return StreamSupport.stream(this.userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

    }
}
