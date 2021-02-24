package com.leduyminh.service.impl;

import javax.inject.Inject;

import com.leduyminh.dao.IUserDAO;
import com.leduyminh.model.User;
import com.leduyminh.service.IUserService;

public class UserService implements IUserService{
	@Inject
	private IUserDAO userDAO;

	@Override
	public User findByUserNameAndPassWord(String userName, String passWord) {
		return userDAO.findByUserNameAndPassWord(userName, passWord);
	}

}
