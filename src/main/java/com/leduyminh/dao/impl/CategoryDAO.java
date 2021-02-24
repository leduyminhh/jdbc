package com.leduyminh.dao.impl;

import java.util.List;

import com.leduyminh.dao.ICategoryDAO;
import com.leduyminh.mapper.CategoryMapper;
import com.leduyminh.model.Category;

public class CategoryDAO extends AbstractDAO<Category> implements ICategoryDAO {

	@Override
	public List<Category> findAll() {
		String sql = "Select * from category";
		return query(sql,new CategoryMapper());
	}

	@Override
	public Category findOne(int id) {
		String sql = "Select * from category where id = ?";
		List<Category> cates = query(sql, new CategoryMapper(),id);
		return cates.isEmpty() ? null : cates.get(0);
	}

	@Override
	public Category findOneByCode(String code) {
		String sql = "Select * from category where code = ?";
		List<Category> cates = query(sql, new CategoryMapper(),code);
		return cates.isEmpty() ? null : cates.get(0);
	}

}
