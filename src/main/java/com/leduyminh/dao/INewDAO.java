package com.leduyminh.dao;

import java.util.List;

import com.leduyminh.model.News;
import com.leduyminh.paging.Pageble;

public interface INewDAO extends GenericDAO<News>{
	List<News> findByCategoryId(int categoryId);
	Integer save(News news);
	void update(News news);
	void delete(int id);
	News findOne(Integer id);
	List<News> findAll(Pageble pageble);
	int getTotalItem();
}
