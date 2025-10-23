package org.example.usermanagement.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.usermanagement.entity.User;
import org.example.usermanagement.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
    public User save(User user){
        return userRepository.save(user);
    }

    public User update(Long id ,User user){
        Optional<User> existingUser = userRepository.findById(id);

        if(existingUser.isEmpty()){
            throw new RuntimeException("User not Found");
        }

        User userUpdate = existingUser.get();

        userUpdate.setUsername(user.getUsername());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPassword( user.getPassword());

        return userRepository.save(userUpdate);
    }
    public void deleteById(Long user){
        userRepository.deleteById(user);
    }



}
