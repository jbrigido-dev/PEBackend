package com.jbrigido.pebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.jbrigido.pebackend.model.User;
import com.jbrigido.pebackend.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping    
    private ResponseEntity<?> getUsers(){
        
        List<User> list = userService.getAll();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There aren't users");
        }

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }    

}
