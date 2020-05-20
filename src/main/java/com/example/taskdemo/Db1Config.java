package com.example.taskdemo;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class Db1Config {

        @Primary
        @Bean(name = "db1DataSourceProperties")
        @ConfigurationProperties("db1.datasource")
        public DataSourceProperties dataSourceProperties() {
            return new DataSourceProperties();
        }

        @Primary
        @Bean(name = "db1DataSource")
        @ConfigurationProperties("db1.datasource.configuration")
        public DataSource dataSource(@Qualifier("db1DataSourceProperties") DataSourceProperties db1DataSourceProperties) {
            return db1DataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class)
                    .build();
        }

}
