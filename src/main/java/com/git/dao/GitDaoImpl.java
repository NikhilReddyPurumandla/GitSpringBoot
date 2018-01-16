package com.git.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.git.dto.LoginDto;
import com.git.dto.RepoDto;
import com.git.util.LoginRowMapper;
import com.git.util.RepoRowMapper;
import com.mysql.jdbc.PreparedStatement;
@Repository("GitDao")
public class GitDaoImpl implements GitDao {
	String mail;
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public int addUser(LoginDto login) {
		// TODO Auto-generated method stub
		System.out.println("email in boot is "+login.getEmail()+" password is "+login.getUsername());

		
		
		String query = "insert into login values(:id,:name)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", login.getEmail());
	
		map.put("name", login.getUsername());
		
		return jdbcTemplate.update(query, map);
		
	}

	@Override
	public int addRepo(RepoDto login) {
		// TODO Auto-generated method stub
		String query = "insert into repo values(:id,:repo,:umail)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", login.getId());
		map.put("repo", login.getRepo());
		map.put("umail", this.mail);
		System.out.println("repo user"+this.mail);
		return jdbcTemplate.update(query, map);
	}

	@Override
	public List<RepoDto> getRepo() {
		// TODO Auto-generated method stub
		System.out.println("select * from repo where umail="+this.mail);
		String query = "select * from repo where umail='" +this.mail+"'";
		return jdbc.query(query, new RepoRowMapper());
	}

	@Override
	public List<LoginDto> getUser() {
		// TODO Auto-generated method stub
		String query = "select * from login";
		return jdbc.query(query, new LoginRowMapper());
	}

	/* @Override
	public Boolean login(LoginDto login) {
		// TODO Auto-generated method stub
		System.out.println("login email is "+login.getEmail()+" password is "+login.getUsername());
		
		String query = "select * from login where email='" + login.getEmail() + "' and UserName='" + login.getUsername()+"'";
		System.out.println(query);
		
		return 0;
		
		
	}
	*/
	public Boolean login(LoginDto login){
		System.out.println("select * from login where email="+login.getEmail()+" and username="+login.getUsername());
		
		 String query = "select * from login where Email=:user and UserName=:pass";
		 Map<String, Object> map = new HashMap<String, Object>();
			map.put("user", login.getEmail());
			map.put("pass", login.getUsername());	
		    this.mail=login.getEmail();
			List<LoginDto> LoginDto=jdbcTemplate.query(query,map,new LoginRowMapper());
		    return LoginDto.isEmpty() ? false:true; 
	}

	@Override
	public int deleteRepo(String repo) {
		// TODO Auto-generated method stub
		System.out.println("boot repo is"+repo);

		String query = "delete from repo where id=?";
	
		return jdbc.update(query,repo);
	}
	

}
