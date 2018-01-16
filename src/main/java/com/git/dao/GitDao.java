package com.git.dao;
import java.util.List;

import com.git.dto.LoginDto;
import com.git.dto.RepoDto;
 
public interface GitDao {

public int addUser(LoginDto login);

public int addRepo(RepoDto repo);

public List<RepoDto> getRepo();

public List<LoginDto> getUser();


public int deleteRepo(String repo);

public Boolean login(LoginDto login);
}
