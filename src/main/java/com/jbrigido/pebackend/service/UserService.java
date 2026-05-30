package com.jbrigido.pebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbrigido.pebackend.model.User;
import com.jbrigido.pebackend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return (List<User>) userRepository.findAll();
    }

}
