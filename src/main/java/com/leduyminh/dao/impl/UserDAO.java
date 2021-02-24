package com.leduyminh.dao.impl;

import java.util.List;

import com.leduyminh.dao.IUserDAO;
import com.leduyminh.mapper.UserMapper;
import com.leduyminh.model.User;

public class UserDAO extends AbstractDAO<User> implements IUserDAO{

	@Override
	public User findByUserNameAndPassWord(String userName, String passWord) {
		StringBuilder sql = new StringBuilder("Select * from user as u");
		sql.append(" inner join role as r on r.id = u.roleid");
		sql.append(" where username=? and password=? and status = 1");
		List<User> users = query(sql.toString(), new UserMapper(),userName,passWord);
		return users.isEmpty() ? null : users.get(0);
	}
	
}
