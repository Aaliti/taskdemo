//package com.example.taskdemo;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//@Service
//@Slf4j
//@EnableScheduling
//public class JobSchedulerService implements JobScheduler{
//
//    @Autowired
//    private JobLauncher jobLauncher;
//
//    @Autowired
//    private Job job;
//
//    @Scheduled(cron = "0 */1 * * * ?")
//    @Override
//    public void run() {
//
//        System.out.println(LocalDateTime.now());
//        try{
//            JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
//            jobParametersBuilder.addDate("time", new Date());
//            JobParameters jobParameters = jobParametersBuilder.toJobParameters();
//            JobExecution execution = jobLauncher.run(job, jobParameters);
//             log.info("Completed");
//        }catch (Exception e){
//            log.error("Error : {} ",e.getMessage());
//        }
//    }
//}
