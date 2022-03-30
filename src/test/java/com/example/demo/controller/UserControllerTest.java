package com.example.demo.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.error.BadRequestDetails;
import com.example.demo.model.entity.UserTransaction;
import com.example.demo.model.to.UserRequestTO;
import com.example.demo.repository.UserRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    public UserRepository userRepository;

    @Test
    public void postSaveTestShouldReturnStatusCode200(){
        BDDMockito.when(userRepository.save(new UserTransaction("test"))).thenReturn(new UserTransaction("test"));
        //Test with 200 OK
        ResponseEntity<String> response = testRestTemplate.postForEntity("/users", new UserRequestTO("test"), String.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void postSaveTestShouldReturnStatusCode400(){
        //Test with 400 BAD_REQUEST - null name
        ResponseEntity<BadRequestDetails> response = testRestTemplate.postForEntity("/users", new UserRequestTO(null), BadRequestDetails.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(response.getBody().getDetail()).isEqualTo("name is mandatory; ");

        //Test with 400 BAD_REQUEST - empty name
        ResponseEntity<BadRequestDetails> response2 = testRestTemplate.postForEntity("/users", new UserRequestTO(""), BadRequestDetails.class);
        Assertions.assertThat(response2.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(response.getBody().getDetail()).isEqualTo("name is mandatory; ");
    }

    @Test
    public void getAllUsersTestShouldReturnStatusCode200(){
        //Test with 200 OK
        ResponseEntity<String> response = testRestTemplate.getForEntity("/users", String.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
