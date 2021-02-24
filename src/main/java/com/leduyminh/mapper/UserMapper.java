package com.leduyminh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.leduyminh.model.Role;
import com.leduyminh.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs) {
		User user = new User();
		try {
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("username"));
			user.setPassWord(rs.getString("password"));
			user.setFullName(rs.getString("fullname"));
			user.setStatus(rs.getInt("status"));
			user.setCreatedDate(rs.getTimestamp("createdate"));
			user.setCreatedBy(rs.getString("createby"));
			try {
				Role role = new Role();
				role.setCode(rs.getString("code"));
				role.setName(rs.getString("name"));
				user.setRole(role);
			} catch (Exception e) {
				e.getMessage();
			}
			if (rs.getTimestamp("modifieddate") != null) {
				user.setModifiedDate(rs.getTimestamp("modifieddate"));
			}
			if (rs.getString("modifiedby") != null) {
				user.setModifiedBy(rs.getString("modifiedby"));
			}
			return user;
		} catch (SQLException e) {
			return null;
		}
	}

}
