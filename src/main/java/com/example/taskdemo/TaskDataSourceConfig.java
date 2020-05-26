package com.example.taskdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class TaskDataSourceConfig extends DefaultTaskConfigurer{

//    @Autowired
//    @Qualifier("batchDataSource")
//    private DataSource primaryDataSource;


    public TaskDataSourceConfig(@Qualifier("batchDataSource") DataSource dataSource) {
        super(dataSource);
    }

    //    @Bean
//    public TaskConfigurer taskConfigurer() {
//        return new DefaultTaskConfigurer(primaryDataSource);
//    }

}
