package com.leduyminh.service;

import com.leduyminh.model.User;

public interface IUserService {
	 User findByUserNameAndPassWord(String userName, String passWord);
}
