package com.leduyminh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.leduyminh.model.News;

public class NewMapper implements RowMapper<News> {

	@Override
	public News mapRow(ResultSet rs) {
		News news = new News();
		try {
			news.setId(rs.getInt("id"));
			news.setTitle(rs.getString("title"));
			news.setContent(rs.getString("content"));
			news.setCategoryId(rs.getInt("categoryid"));
			news.setThumbnail(rs.getString("thumbnail"));
			news.setShortDescription(rs.getString("shortdescription"));
			news.setCreatedDate(rs.getTimestamp("createdate"));
			news.setCreatedBy(rs.getString("createby"));
			if (rs.getTimestamp("modifieddate") != null) {
				news.setModifiedDate(rs.getTimestamp("modifieddate"));
			}
			if (rs.getString("modifiedby") != null) {
				news.setModifiedBy(rs.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			return null;
		}
	}
}
