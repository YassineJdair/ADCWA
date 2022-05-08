package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.exceptions.DepartmentException;
import com.example.demo.models.Department;
import com.example.demo.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository dr;
	
	public Iterable<Department> findAll(){
		return dr.findAll();
	}
	
	public void updateDept(String did, Department d) throws DepartmentException
    {
        Optional<Department> dept = dr.findByDid(did);
        if(dept.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Department ID: " + did + " doesnt exist");
        }
        dept.get().setLocation(d.getLocation());
        dept.get().setName(d.getName());
        dr.save(dept.get());


    }
}
