package com.redtheme.example.multitenancy;

import org.springframework.stereotype.Component;

@Component
public class Tenant {

	private String tenantName;

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	
}
