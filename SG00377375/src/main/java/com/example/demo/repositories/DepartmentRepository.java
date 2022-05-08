package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
	
	public Optional<Department> findByDid(String did); 

}
