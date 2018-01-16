package com.git.util;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.git.dto.LoginDto;


public class LoginRowMapper implements RowMapper<LoginDto> {

	@Override
	public LoginDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoginDto login =new LoginDto();
		login.setEmail(rs.getString("Email"));
		login.setUsername(rs.getString("UserName"));

	
		return login;
	}

}