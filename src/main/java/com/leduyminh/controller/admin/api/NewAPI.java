package com.leduyminh.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leduyminh.model.News;
import com.leduyminh.model.User;
import com.leduyminh.service.INewService;
import com.leduyminh.utils.HttpUtil;
import com.leduyminh.utils.SessionUlti;

@WebServlet(urlPatterns = { "/api-admin-new" })
public class NewAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private INewService newService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		News news = HttpUtil.of(request.getReader()).toModel(News.class);
		news.setCreatedBy( ((User)SessionUlti.getInstance().getValue(request, "USERMODEL")).getUserName());
		news = newService.save(news);
		mapper.writeValue(response.getOutputStream(),news);
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		News news = HttpUtil.of(request.getReader()).toModel(News.class);
		news.setModifiedBy( ((User)SessionUlti.getInstance().getValue(request, "USERMODEL")).getUserName());
		news = newService.update(news);
		mapper.writeValue(response.getOutputStream(),news);
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		News news = HttpUtil.of(request.getReader()).toModel(News.class);
		newService.delete(news.getIds());
		mapper.writeValue(response.getOutputStream(),"{}");
		
	}

}
