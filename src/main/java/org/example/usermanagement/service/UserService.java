package org.example.usermanagement.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.usermanagement.entity.User;
import org.example.usermanagement.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


}
