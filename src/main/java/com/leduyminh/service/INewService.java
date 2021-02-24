package com.leduyminh.service;

import java.util.List;

import com.leduyminh.model.News;
import com.leduyminh.paging.Pageble;

public interface INewService {
	List<News> findByCategoryId(int categoryId);
	News save(News news);
	News update(News news);
	void delete(int[] ids);
	List<News> findAll(Pageble pageble);
	int getTotalItem();
	News findOne(Integer id);
}
