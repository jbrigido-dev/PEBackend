package com.jbrigido.pebackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.jbrigido.pebackend.model.User;

public interface UserRepository  extends CrudRepository<User, Long>{

    
}
