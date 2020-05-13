package com.example.taskdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Task2ItemProcessor implements ItemProcessor<String, String> {


    @Override
    public String process(String item) throws Exception {

        String task1Processor = "Processing 2 :"+item;
        return task1Processor;
    }
}
