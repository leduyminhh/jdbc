package com.leduyminh.utils;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

public class FormUlti {
	/*mapper name input vs Field*/
	public static <T> T toModel(Class<T> tClass,HttpServletRequest request)
	{
		T object = null;
		try {
			object = tClass.newInstance();
			BeanUtils.populate(object,request.getParameterMap());
		}catch (Exception e) {
			e.getMessage();
		}
		return object;
	}
}
