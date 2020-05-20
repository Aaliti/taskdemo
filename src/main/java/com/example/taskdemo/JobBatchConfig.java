package com.example.taskdemo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * Configuration class
 */

@Configuration
@EnableBatchProcessing
public class JobBatchConfig extends DefaultBatchConfigurer {

    @Autowired
    @Override
    public void setDataSource(@Qualifier("db2DataSource") DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    private static final int CHUNK = 1;

    @Value("${jobName}")
    String jobName;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ItemReader<String> task1ItemReader;
    @Autowired
    private ItemProcessor<String, String> task1ItemProcessor;
    @Autowired
    private ItemWriter<String> task1ItemWriter;

    @Autowired
    private ItemReader<String> task2ItemReader;
    @Autowired
    private ItemProcessor<String, String> task2ItemProcessor;
    @Autowired
    private ItemWriter<String> task2ItemWriter;



    @Bean
    public Step task1Step() {
        return stepBuilderFactory.get("task1Step")
                .<String, String>chunk(CHUNK)
                .reader(task1ItemReader)
                .processor(task1ItemProcessor)
                .writer(task1ItemWriter)
                .build();
    }

    @Bean
    public Step task2Step() {
        return stepBuilderFactory.get("task2Step")
                .<String, String>chunk(CHUNK)
                .reader(task2ItemReader)
                .processor(task2ItemProcessor)
                .writer(task2ItemWriter)
                .build();
    }

    @Bean
    public Job job() {


        if (jobName.equals("job1")) {


            return jobBuilderFactory.get("Task1job")
                    .start(task1Step())
                    .build();

        } else if (jobName.equals("job2")) {


            return jobBuilderFactory.get("Task2job")
                    .start(task2Step())
                    .build();
        } else if (jobName.equals("composedTask")) {


            return jobBuilderFactory.get("ComposedTaskjob")
                    .start(task1Step())
                    .next(task2Step())
                    .build();
        } else {
            return null;
        }
    }

}