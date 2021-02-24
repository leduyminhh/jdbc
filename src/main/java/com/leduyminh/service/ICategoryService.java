package com.leduyminh.service;

import java.util.List;

import com.leduyminh.model.Category;


public interface ICategoryService {
	List<Category> findAll();
	Category findOne(int id);
}
