package com.leadership.user.rank.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSourceBuilder.url("jdbc:sqlserver://userscore.database.windows.net;databaseName=UserLeadership");
        dataSourceBuilder.username("ashishkumar.4029");
        dataSourceBuilder.password("Gmail@3107");
        return dataSourceBuilder.build();
    }
}
