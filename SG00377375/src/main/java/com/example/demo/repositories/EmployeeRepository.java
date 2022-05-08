package com.example.demo.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	@Transactional
	public Optional<Employee> deleteByEid(String eid); 


}