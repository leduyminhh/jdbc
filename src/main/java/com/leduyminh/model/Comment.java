package com.leduyminh.model;

public class Comment extends Base<Comment>{
	private String content;
	private int userId;
	private int newsId;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
