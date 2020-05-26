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
public class BizConfig {

        @Primary
        @Bean(name = "bizDataSourceProperties")
        @ConfigurationProperties("biz.datasource")
        public DataSourceProperties dataSourceProperties() {
            return new DataSourceProperties();
        }

        @Primary
        @Bean(name = "bizDataSource")
        @ConfigurationProperties("biz.datasource.configuration")
        public DataSource dataSource(@Qualifier("bizDataSourceProperties") DataSourceProperties bizDataSourceProperties) {
            return bizDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class)
                    .build();
        }

}
