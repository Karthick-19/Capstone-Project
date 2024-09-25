package com.example.ProjectManagement.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ProjectManagement.Entity.UserDTO;

@Service
public class UserClient {

    private final RestTemplate restTemplate;

//    @Value("${um.service.url}")  // Example: http://localhost:8081
//    private String userMicroserviceUrl;

    public UserClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDTO getUserById(int userId) {
        String url = "http://localhost:7050/userdetailsid/" + userId;
        return restTemplate.getForObject(url, UserDTO.class);
    }
}

