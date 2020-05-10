package com.redtheme.example.multitenancy;

public class CognitoContext {
	private static final ThreadLocal<String> tenantLocal = new ThreadLocal<String>();
	
	public static String getCurrentTenant() {
		return tenantLocal.get();
	}
	public static void setCurrentTenant(String tenant) {
		tenantLocal.set(tenant);
	}
}
