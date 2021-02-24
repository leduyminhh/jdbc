package com.leduyminh.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.leduyminh.dao.ICategoryDAO;
import com.leduyminh.model.Category;
import com.leduyminh.service.ICategoryService;

public class CategoryService implements ICategoryService{

//	Basic
//	private ICategoryDAO categoryDAO;
//	public CategoryService() {
//		categoryDAO = new CategoryDAO();
//	}
	
//	weld.servlet
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public Category findOne(int id) {
		return categoryDAO.findOne(id);
	}

}
