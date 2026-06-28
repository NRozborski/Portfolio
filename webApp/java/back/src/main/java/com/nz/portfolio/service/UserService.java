package com.nz.portfolio.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nz.portfolio.model.User;
import com.nz.portfolio.repository.UserRepository;

@Component
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void saveOrUpdate(String email, String name) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        User user;

        if (userRepository.findByEmail(email) != null) {
            user = userRepository.findByEmail(email);
        } else {
            user = new User(email, name);
            userRepository.save(user);
        }



        // Update name if it has changed for existing users
        if (!user.getUsername().equals(name)) {
            user.setUsername(name);
            userRepository.save(user);
        }
    }

}
