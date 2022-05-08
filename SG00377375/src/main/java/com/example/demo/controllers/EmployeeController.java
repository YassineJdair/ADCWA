package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.exceptions.EmployeeException;
import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeService;
import com.example.demo.validations.EmployeeValidations;

@RestController
@Validated
public class EmployeeController {
	
	@Autowired
	EmployeeService es;
	
	//list all employees
	@GetMapping(path = "/api/employees")
	public Iterable<Employee> getEmployees(){
		return es.findEmployees();
		
	}
	
	//delete eid method & response
	@DeleteMapping(path = "/api/employees/{eid}")
	void deleteByEid(@PathVariable String eid) {
		es.deleteByEid(eid);
		
	if(eid.isEmpty()) 
	{
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee: " + eid + " Not Found");
	}
	else 
	{//throws error if  successfully deleted employee
		throw new ResponseStatusException(HttpStatus.OK, "Successfully deleted: " + eid);
	}
			
	}
	
	//adding employee
	@Validated(EmployeeValidations.class)
	@PostMapping(path = "/api/employees")
	public void addEmployee(@Valid @RequestBody Employee employee) {
		try {
			es.save(employee);
		} catch (EmployeeException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
		}
	}
		
}