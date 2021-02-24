package com.leduyminh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leduyminh.constant.SystemConstant;
import com.leduyminh.model.User;
import com.leduyminh.utils.SessionUlti;

public class AuthorizaticationFilter implements Filter{

	@SuppressWarnings("unused")
	private ServletContext context;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		this.context = filterConfig.getServletContext();
	}
	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletrequest;
		HttpServletResponse response= (HttpServletResponse) servletresponse;
		String url = request.getRequestURI();
		
		if(url.startsWith("/jsp-servlet-jdbc/admin"))
		{
			User model = (User) SessionUlti.getInstance().getValue(request,"USERMODEL");
			if(model != null)
			{
				if(model.getRole().getCode().equals(SystemConstant.USER))
				{
					response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_permission&alert=danger");
				}else if(model.getRole().getCode().equals(SystemConstant.ADMIN)) {
					filterChain.doFilter(request, response);
				}
				
			}else {
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
			}
		}
		else {
			filterChain.doFilter(request, response);
		}
		
		 	
	}

}
