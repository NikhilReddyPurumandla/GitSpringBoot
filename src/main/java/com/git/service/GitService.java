package com.git.service;

import java.util.List;
import com.git.dto.LoginDto;
import com.git.dto.RepoDto;

public interface GitService {

	public int addUser(LoginDto login);

	public List<LoginDto> getAllUsers();

	public List<LoginDto> getUser();

	public List<RepoDto> getRepo();

	public int addRepo(RepoDto repo);

	public  Boolean getLogin(LoginDto login);
	
	
	
	public int deleteRepo(String repo);

	



}
