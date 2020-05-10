package com.redtheme.example.multitenancy;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.stereotype.Component;

@Component
public class CongnitoMultiTenantConnectionProvider implements MultiTenantConnectionProvider{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3314740748499406136L;
	
	private ConnectionProvider connectionProvider;
	
	private DataSource dataSource;
	
	private String defaultSchema;

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getAnyConnection() throws SQLException {
		// TODO Auto-generated method stub
		return this.getConnectionProvider().getConnection();
	}



	@Override
	public Connection getConnection(String tenantIdentifier) throws SQLException {
		System.out.println("Inside getConnection()");
		Connection connection = null;
		Statement statement = null;
		try {
			connection = this.getAnyConnection();
			statement = connection.createStatement();
			statement.execute(this.getSchemaChangeSQL(tenantIdentifier));
		} catch (SQLException sqlException) {
			throw sqlException;
		}
		finally {
			if (statement != null) {
				statement.close();
			}
		}
		return connection;
	}

	@Override
	public void releaseAnyConnection(Connection connection) throws SQLException {
		System.out.println("Inside releaseAnyConnection()");
		this.getConnectionProvider().closeConnection(connection);
	}
	
	@Override
	public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
		System.out.println("Inside releaseConnection()");
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute(this.getSchemaChangeSQL(this.defaultSchema));
		}
		catch (SQLException e) {
			throw e;
		}
		finally {
			if (statement != null) {
				statement.close();
			}
		}
		getConnectionProvider().closeConnection(connection);
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

	protected ConnectionProvider getConnectionProvider() {
		System.out.println("Inside getConnectionProvider()");
		if (this.connectionProvider == null) {
			this.connectionProvider = new DatasourceConnectionProviderImpl();
			((DatasourceConnectionProviderImpl)this.connectionProvider).setDataSource(this.getDataSource());
			((DatasourceConnectionProviderImpl)this.connectionProvider).configure(new HashMap<>());
		}
		return this.connectionProvider;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String getDefaultSchema() {
		return defaultSchema;
	}

	public void setDefaultSchema(String defaultSchema) {
		this.defaultSchema = defaultSchema;
	}
	
	private String getSchemaChangeSQL(String tenantId) {
		System.out.println("Inside getSchemaChangeSQL()");
		return "USE ".concat(tenantId.toUpperCase());
	}
	
	
}
