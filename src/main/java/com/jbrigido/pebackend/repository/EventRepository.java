package com.jbrigido.pebackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.jbrigido.pebackend.model.Event;

public interface EventRepository extends CrudRepository<Event, Long>{

    
}