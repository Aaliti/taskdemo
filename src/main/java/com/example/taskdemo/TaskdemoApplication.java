package com.example.taskdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Date;


@EnableTask
@SpringBootApplication
@Slf4j
//@EnableScheduling
public class TaskdemoApplication implements CommandLineRunner {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    public static void main(String[] args) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        SpringApplication.run(TaskdemoApplication.class, args);
    }

    //@Scheduled(cron = "0 */1 * * * ?")
    //@Bean

    @Override
    public void run(String... args) throws Exception {
        log.info("time : {} ",LocalDateTime.now());
        try{
            JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
            jobParametersBuilder.addDate("time", new Date());
            JobParameters jobParameters = jobParametersBuilder.toJobParameters();
            JobExecution execution = jobLauncher.run(job, jobParameters);
            log.info("Completed");
        }catch (Exception e){
            log.error("Error : {} ",e.getMessage());
        }
    }
}
