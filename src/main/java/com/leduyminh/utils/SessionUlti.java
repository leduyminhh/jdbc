package com.leduyminh.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUlti {
	public static SessionUlti sessionUlti;
	
	public static SessionUlti getInstance() {
		if(sessionUlti == null) {
			sessionUlti = new SessionUlti();
		}
		return sessionUlti;
	}
	public void putValue(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}

	public Object getValue(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);

	}
	public void removeValue(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}
	
}