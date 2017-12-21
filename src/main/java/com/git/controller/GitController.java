package com.git.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.git.dto.LoginDto;
import com.git.dto.RepoDto;
import com.git.service.GitService;

@EnableAutoConfiguration
@RestController

@RequestMapping(value = "git")
public class GitController {
	@Autowired
	GitService gitService;
	@CrossOrigin
	@RequestMapping(value = "addUser", method = RequestMethod.POST, consumes = { "application/json" })
	public int addUser(@RequestBody LoginDto login){
		return gitService.addUser(login);
	}
	@CrossOrigin
	@RequestMapping(value = "getUser", method = RequestMethod.GET)	
	public List<LoginDto> getUser(){
		return gitService.getUser();
	}
	@CrossOrigin
	@RequestMapping(value = "addRepo", method = RequestMethod.POST, consumes = { "application/json" })
	
	public int addRepo(@RequestBody RepoDto repo){
		return gitService.addRepo(repo);
	}
	@CrossOrigin
	@RequestMapping(value = "getRepo", method = RequestMethod.GET)
	
	public List<RepoDto> getRepo(){
		return gitService.getRepo();
	}
	@CrossOrigin
	@RequestMapping(value = "getAllUsers")

	public List<LoginDto> getAllUsers() {
		return gitService.getAllUsers();
	}
}