package com.jbrigido.pebackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.jbrigido.pebackend.model.User;
import java.util.Optional;



public interface UserRepository  extends CrudRepository<User, Long>{

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByEnrollment(String enrollment);
}
