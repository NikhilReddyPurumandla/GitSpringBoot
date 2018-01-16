package com.git.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
		System.out.println("controller id "+login.getEmail());
		System.out.println("controller username "+login.getUsername());
		return gitService.addUser(login);
	}
	@CrossOrigin
	@RequestMapping(value = "getLogin", method = RequestMethod.POST, consumes = { "application/json" })	
	/*public Boolean getLogin(@RequestBody LoginDto login){
		System.out.println("controller id "+login.getEmail());
		return gitService.getLogin(login);
	}*/
	public  ResponseEntity<String> login(@RequestBody LoginDto login, HttpServletResponse response) {
		if (gitService.getLogin(login) == true) {
			String uuid = UUID.randomUUID().toString();
	        response.addCookie(new Cookie("x-auth-token", uuid));
	        return new ResponseEntity<String>(uuid,HttpStatus.OK);    

		}
		else{
			return new ResponseEntity<String>("",HttpStatus.OK);    
		}
	}
	@CrossOrigin
	@RequestMapping(value = "addRepo", method = RequestMethod.POST, consumes = { "application/json" })
	
	public int addRepo(@RequestBody RepoDto repo){
		System.out.println("adding  "+repo);
		return gitService.addRepo(repo);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	//@RequestMapping(value = "deleteRepo", method = RequestMethod.GET)

	@RequestMapping(value = "deleteRepo/{repo}", method = RequestMethod.DELETE)
	public int deleteRepo(@PathVariable String repo) {
		
		return gitService.deleteRepo(repo);
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