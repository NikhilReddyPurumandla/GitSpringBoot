package com.git.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.git.dto.RepoDto;


public class RepoRowMapper implements RowMapper<RepoDto> {

	@Override
	public RepoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		RepoDto repo =new RepoDto();
		repo.setId(rs.getString("Id"));
		repo.setRepo(rs.getString("Repo"));
		repo.setUmail(rs.getString("Umail"));
	
		return repo;
	}

}