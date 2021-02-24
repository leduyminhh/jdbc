package com.leduyminh.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leduyminh.constant.SystemConstant;
import com.leduyminh.model.News;
import com.leduyminh.paging.PageRequest;
import com.leduyminh.paging.Pageble;
import com.leduyminh.service.ICategoryService;
import com.leduyminh.service.INewService;
import com.leduyminh.sort.Sorter;
import com.leduyminh.utils.FormUlti;
import com.leduyminh.utils.MessageUlti;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	INewService newService;
	
	@Inject
	ICategoryService categoryService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		News model = FormUlti.toModel(News.class, request);
		String view = "";
		if(model.getType().equals(SystemConstant.lIST))
		{
		Pageble pageble = new PageRequest(model.getPage(),model.getMaxPageItem(),
				new Sorter(model.getSortName(),model.getSortBy()));
		
		model.setLst(newService.findAll(pageble));
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));

		view = "/views/admin/new/list.jsp";
		}else if(model.getType().equals(SystemConstant.EDIT)) {
			if(model.getId() != null)
			{
				model = newService.findOne(model.getId());
			}else {
				
			}
			request.setAttribute("categories",categoryService.findAll());
			view = "/views/admin/new/edit.jsp";
		}
		MessageUlti.showMessage(request);
		request.setAttribute(SystemConstant.MODEL,model);
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	}

}
