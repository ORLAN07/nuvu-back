package com.project.nuvu.service;

import com.project.nuvu.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User findByUser(String user);
    public User save(User user);

}
