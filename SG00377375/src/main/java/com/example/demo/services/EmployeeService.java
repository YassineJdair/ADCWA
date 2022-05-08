package com.example.demo.services;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.EmployeeException;
import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	@Autowired
	EmployeeRepository er;
	
	//list method
	public Iterable<Employee> findEmployees() {
		return er.findAll();
	}
	
	
	//delete method
	public void deleteByEid(String eid) {
	      er.deleteByEid(eid);
	   }
	
	//adds employee and saves to database
	public void save(Employee employee) throws EmployeeException{
		try {
			er.save(employee);
			
		} catch(DataIntegrityViolationException e) {
			//throws error
			throw new EmployeeException ("Employee: " + employee.getEid() + " already exists");
		}
	}
	
}