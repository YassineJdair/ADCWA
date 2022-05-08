package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ProjectException;
import com.example.demo.models.Project;
import com.example.demo.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository pr;
	
	public Iterable<Project> findProjects(){
		return pr.findAll();
	}
	
	//delete method
		public void deleteByPid(String pid) throws ProjectException 
		{
		      pr.deleteByPid(pid);
		   }

}
