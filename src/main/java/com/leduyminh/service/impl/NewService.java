package com.leduyminh.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.leduyminh.dao.ICategoryDAO;
import com.leduyminh.dao.INewDAO;
import com.leduyminh.model.Category;
import com.leduyminh.model.News;
import com.leduyminh.paging.Pageble;
import com.leduyminh.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDAO;
	
	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<News> findByCategoryId(int categoryId) {
		return newDAO.findByCategoryId(categoryId);
	}

	@Override
	public News save(News news) {
		news.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Category cate = categoryDAO.findOneByCode(news.getCategoryCode());
		news.setCategoryId(cate.getId());
		Integer newid = newDAO.save(news);
		return newDAO.findOne(newid);
	}

	@Override
	public News update(News news) {
		News oldNews = newDAO.findOne(news.getId());
		news.setCreatedDate(oldNews.getCreatedDate());
		news.setCreatedBy(oldNews.getCreatedBy());
		news.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		Category cate = categoryDAO.findOneByCode(news.getCategoryCode());
		news.setCategoryId(cate.getId());
		newDAO.update(news);
		return newDAO.findOne(news.getId());
	}

	@Override
	public void delete(int[] ids) {
		for (int id : ids) {
			newDAO.delete(id);
		}

	}

	@Override
	public List<News> findAll(Pageble pageble) {
		return newDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDAO.getTotalItem();
	}

	@Override
	public News findOne(Integer id) {
		News news = newDAO.findOne(id);
		Category cate = categoryDAO.findOne(news.getCategoryId());
		news.setCategoryCode(cate.getCode());
		return news;
	}

}
