package com.git.dao;

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
@Repository("GitDao")
public class GitDaoImpl implements GitDao {
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	@Override
	public int addUser(LoginDto login) {
		// TODO Auto-generated method stub
		String query = "insert into login values(:id,:name)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", login.getEmail());
		map.put("name", login.getUserName());
		return jdbcTemplate.update(query, map);
		
	}

	@Override
	public int addRepo(RepoDto login) {
		// TODO Auto-generated method stub
		String query = "insert into repo values(:id,:name,:email)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", login.getId());
		map.put("name", login.getRepo());
		map.put("email", login.getUmail());
		return jdbcTemplate.update(query, map);
	}

	@Override
	public List<RepoDto> getRepo() {
		// TODO Auto-generated method stub
		String query = "select * from repo";
		return jdbc.query(query, new RepoRowMapper());
	}

	@Override
	public List<LoginDto> getUser() {
		String query = "select * from login";

		return jdbc.query(query, new LoginRowMapper());
	}

}
