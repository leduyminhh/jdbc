package com.leduyminh.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leduyminh.model.User;
import com.leduyminh.service.ICategoryService;
import com.leduyminh.service.INewService;
import com.leduyminh.service.IUserService;
import com.leduyminh.utils.FormUlti;
import com.leduyminh.utils.SessionUlti;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/thoat" }) // muti
public class HomeController extends HttpServlet {

	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewService newService;

	@Inject
	private IUserService userService;

	private static final long serialVersionUID = 7723422175234741322L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ResourceBundle mybundle = ResourceBundle.getBundle("message");
		String action = request.getParameter("action");
		
		if (action != null && action.equals("login")) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if(message != null && alert != null)
			{
				request.setAttribute("message",mybundle.getString(message));
				request.setAttribute("alert",alert);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/login.jsp");
			dispatcher.forward(request, response);
		} else if (action != null && action.equals("logout")) {
			SessionUlti.getInstance().removeValue(request, "USERMODEL");
			response.sendRedirect(request.getContextPath() + "/trang-chu");
			return;
		} else {
			request.setAttribute("categorys", categoryService.findAll());
			request.setAttribute("new", newService.findByCategoryId(1));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/home.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = request.getParameter("action");
		if (action != null && action.equals("login")) {
			User model = FormUlti.toModel(User.class, request);
			model = userService.findByUserNameAndPassWord(model.getUserName(), model.getPassWord());
			if (model != null) {
				SessionUlti.getInstance().putValue(request, "USERMODEL", model);

				if (model.getRole().getCode().equals("USER")) {
					response.sendRedirect(request.getContextPath() + "/trang-chu");
					return;
				} else if (model.getRole().getCode().equals("ADMIN")) {
					response.sendRedirect(request.getContextPath() + "/admin");
					return;
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=user_password_isvalid&alert=danger");
				return;
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
