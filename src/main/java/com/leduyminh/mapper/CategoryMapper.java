package com.leduyminh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.leduyminh.model.Category;

public class CategoryMapper implements RowMapper<Category>{

	@Override
	public Category mapRow(ResultSet rs) {
		Category category = new Category();
		try {
			category.setId(rs.getInt("id"));
			category.setCode(rs.getString("code"));
			category.setName(rs.getString("name"));
			return category;
		} catch (SQLException e) {
			return null;
		}
	}
}
