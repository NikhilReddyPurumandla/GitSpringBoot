package com.git.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.git.dao.GitDao;
import com.git.dto.LoginDto;
import com.git.dto.RepoDto;
@Component
@Repository("GitService")
public class GitServiceImpl implements GitService {
	@Autowired
	GitDao gitDao;
	@Override
	public int addUser(LoginDto login) {
		// TODO Auto-generated method stub
		return gitDao.addUser(login);
	}

	@Override
	public List<LoginDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoginDto> getUser() {
		// TODO Auto-generated method stub
		return gitDao.getUser();
	}

	@Override
	public List<RepoDto> getRepo() {
		// TODO Auto-generated method stub
		return gitDao.getRepo();
	}

	@Override
	public int addRepo(RepoDto repo) {
		// TODO Auto-generated method stub
		return gitDao.addRepo(repo);
	}

}
