package com.jbrigido.pebackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbrigido.pebackend.model.User;
import com.jbrigido.pebackend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getByID(Long id) {
        return userRepository.findById(id);
    }

    public void register(User user) {
        userRepository.save(user);
    }

    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }
     public Optional<User> getByEnrollment(String enrolment) {
        return userRepository.findByEnrollment(enrolment);
    }

}
