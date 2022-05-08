package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.exceptions.DepartmentException;
import com.example.demo.models.Department;
import com.example.demo.services.DepartmentService;
import com.example.demo.validations.DepartmentValidations;

@RestController
@Validated
public class DepartmentController {
	
	@Autowired
	DepartmentService ds;
	
	//lists departments
	@GetMapping(path = "/api/departments")
	public Iterable<Department> getDepartmenst(){
		return ds.findAll();
		
	}
	
	//adding department method
	@Validated(DepartmentValidations.class)
    @PutMapping(path = "/api/departments/{did}")
    public void updateDepartment(@PathVariable String did, @Valid @RequestBody Department d) {
		try {
			 ds.updateDept(did, d);
		}catch(DepartmentException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
       
	}
    
	
}



