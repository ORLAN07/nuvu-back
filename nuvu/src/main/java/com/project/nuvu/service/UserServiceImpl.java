package com.project.nuvu.service;

import com.project.nuvu.model.User;
import com.project.nuvu.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    public final UserRepository userRepository;

    @Override
    public User findByUser(String user) {
        return userRepository.findByUserName(user);
    }

    @Override
    public User save(User user) {
        User userRes = userRepository.findByUserName(user.getUserName());
        if (userRes == null) {
            return userRepository.save(user);
        }
        return null;
    }
}
