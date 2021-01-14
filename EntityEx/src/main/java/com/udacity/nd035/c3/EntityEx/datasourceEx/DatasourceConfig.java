package com.udacity.nd035.c3.EntityEx.datasourceEx;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Bean
    @Primary
    // @ConfigurationProperties("com.udacity.datasource")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties getDataSourceProperties () {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    // @ConfigurationProperties(prefix = "com.udacity.datasource.configuration")
    @ConfigurationProperties(prefix = "spring.datasource.configuration")
    public DataSource getDataSource (DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
}
