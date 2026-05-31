package com.jbrigido.pebackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.jbrigido.pebackend.model.User;
import com.jbrigido.pebackend.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private ResponseEntity<?> getUsers() {

        List<User> list = userService.getAll();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There aren't users");
        }

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> retrieved = userService.getByID(id);
        if (!retrieved.isEmpty()) {
            User user = retrieved.get();
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        Optional<User> retrievedByEnrollment = userService.getByEnrollment(user.getEnrollment());
        if (!retrievedByEnrollment.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This enrollment is used by another user.");
        }
        Optional<User> retrievedByUserName = userService.getByUsername(user.getUsername());
        if (!retrievedByUserName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This username is used by another user.");
            
        }
        Optional<User> retrievedByEmail = userService.getByEmail(user.getEmail());
        if (!retrievedByEmail.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This email is used by another user.");
        }
        userService.register(user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully Registered!");

    }
}
