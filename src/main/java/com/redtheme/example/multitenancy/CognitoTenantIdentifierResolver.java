package com.redtheme.example.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class CognitoTenantIdentifierResolver implements CurrentTenantIdentifierResolver{

	private String defaultSchema;
	
	@Override
	public String resolveCurrentTenantIdentifier() {
		System.out.println("Resolve Current Tenant Indentifier");
		String tenant = CognitoContext.getCurrentTenant();
		System.out.println("Get Tenant Name from congnio context: "+tenant);
		if (tenant == null) {
			return defaultSchema;
		} else {
			
			return this.getSchemaName(tenant);
		}
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return false;
	}

	public String getDefaultSchema() {
		return defaultSchema;
	}

	public void setDefaultSchema(String defaultSchema) {
		this.defaultSchema = defaultSchema;
	}

	private String getSchemaName(String tenant) {
		String schemaName = tenant;
		System.out.println("set schemaName by tenant name: "+schemaName);
		return schemaName;
	}
}
