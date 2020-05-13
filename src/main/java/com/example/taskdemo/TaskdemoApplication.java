package com.example.taskdemo;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@EnableTask
@SpringBootApplication
public class TaskdemoApplication {

    public static void main(String[] args) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        SpringApplication.run(TaskdemoApplication.class, args);

    }


    @Autowired
    private  JobLauncher jobLauncher;

    @Autowired
    private  Job job;

    @Bean
    public  void importSiteFromGoogleTest() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {



        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        //jobParametersBuilder.addString("siteName", siteName);
        jobParametersBuilder.addDate("time", new Date());
        JobParameters jobParameters = jobParametersBuilder.toJobParameters();
        JobExecution execution = jobLauncher.run(job, jobParameters);





    }
}
