package com.jbrigido.pebackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.jbrigido.pebackend.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
    
}
