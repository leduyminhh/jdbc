package com.leduyminh.dao;

import java.util.List;

import com.leduyminh.model.Category;

public interface ICategoryDAO extends GenericDAO<Category>{
	List<Category> findAll();
	Category findOne(int id);
	Category findOneByCode(String code);
}
