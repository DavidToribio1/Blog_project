package com.blog.blog_project.services;

import com.blog.blog_project.entities.User;
import com.blog.blog_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    //TODO: Error handling.
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(RuntimeException::new);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}