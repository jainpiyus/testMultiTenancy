package com.redtheme.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.redtheme.example.multitenancy.CognitoContext;
import com.redtheme.example.multitenancy.HttpUtil;

@Component
public class CongnitoInterceptor extends HandlerInterceptorAdapter{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("inside preHandler");
		String tenantName = HttpUtil.getTenantName(request);
		CognitoContext.setCurrentTenant(tenantName);
		System.out.println("set TenantName: "+ tenantName);
		return super.preHandle(request, response, handler);
		
	}
}
