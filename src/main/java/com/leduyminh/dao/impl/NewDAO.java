package com.leduyminh.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.leduyminh.dao.INewDAO;
import com.leduyminh.mapper.NewMapper;
import com.leduyminh.model.News;
import com.leduyminh.paging.Pageble;

public class NewDAO extends AbstractDAO<News> implements INewDAO {
	@Override
	public List<News> findByCategoryId(int categoryId) {
		String sql = "Select * from news where categoryid=?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Integer save(News news) {
		StringBuilder sql = new StringBuilder("insert into news (title, thumbnail, shortdescription, ");
		sql.append("content, categoryid, createdate, createby) values (?, ?, ?, ?, ?, ?, ?)");
		return (Integer)insert(sql.toString(), news.getTitle(), news.getThumbnail(), news.getShortDescription(), 
				news.getContent(), news.getCategoryId(), news.getCreatedDate(), news.getCreatedBy());
	}

	@Override
	public void update(News news) {
		StringBuilder sql = new StringBuilder("update news set title = ?, thumbnail = ?, ");
		sql.append("shortdescription = ?, content = ?, categoryid = ?, ");
		sql.append("createdate = ?, createby = ?, modifieddate = ?, ");
		sql.append("modifiedby = ? where id = ?");
		update(sql.toString(), news.getTitle(), news.getThumbnail(), news.getShortDescription(),
				news.getContent(), news.getCategoryId(), news.getCreatedDate(), news.getCreatedBy(), 
				news.getModifiedDate(), news.getModifiedBy(), news.getId());
	}

	@Override
	public void delete(int id) {
		String sql = "Delete from news where id = ?";
		update(sql,id);
	}

	@Override
	public News findOne(Integer id) {
		String sql = "Select * from news where id = ?";
		List<News> news = query(sql, new NewMapper(),id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public List<News> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("Select * from news");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
		}
		if (pageble.getOffset() != null && pageble.GetLimit() != null) {
			sql.append(" LIMIT "+pageble.getOffset()+", "+pageble.GetLimit()+"");
		}
		return query(sql.toString(),new NewMapper());
	}
	@Override
	public int getTotalItem() {
		String sql = "Select count(*) from news";
		return count(sql);
	}

}
