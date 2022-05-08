package com.example.demo.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
	
	@Transactional
	public Optional<Project> deleteByPid(String pid); 

}
