package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.exceptions.ProjectException;
import com.example.demo.models.Project;
import com.example.demo.services.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	ProjectService ps;
	
	@GetMapping(path = "/projects")
	public Iterable<Project> getProjects(){
		return ps.findProjects();
	}
	
	//delete pid method & response
		@DeleteMapping(path = "/api/projects/{pid}")
		void deleteByEid(@PathVariable String pid) throws ProjectException {
			ps.deleteByPid(pid);
			
		if(pid.isEmpty()) 
		{
			
			throw new ResponseStatusException(HttpStatus.OK, "Successfully deleted: " + pid);
		}
		/*else 
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project: " + pid + "Not found");
			
		}*/
	}

}
