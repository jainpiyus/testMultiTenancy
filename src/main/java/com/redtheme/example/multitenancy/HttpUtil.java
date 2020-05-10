package com.redtheme.example.multitenancy;

import javax.servlet.http.HttpServletRequest;

public class HttpUtil {

	public static final String TENANT_NAME = "tenant_name";
	
	
	public static final String getTenantName(HttpServletRequest request) {
		String name = request.getHeader("tenant_name");
		return name;
	}
}
