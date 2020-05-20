package com.example.taskdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class Task1ItemWriter implements ItemWriter<String> {


    @Override
    public void write(List<? extends String> items) throws Exception {

        items.forEach(item -> System.out.println("Writing 1 : "+ item));
    }

    @AfterStep
    public void afterStep1() throws InterruptedException {
        System.out.println("--------------- fin step 1");
        Thread.sleep(60000);
    }
}