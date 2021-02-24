package com.leduyminh.dao;

import com.leduyminh.model.User;

public interface IUserDAO {
  User findByUserNameAndPassWord(String userName, String passWord);
}
