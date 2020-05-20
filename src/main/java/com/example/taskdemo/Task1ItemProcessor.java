package com.example.taskdemo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Task1ItemProcessor implements ItemProcessor<String, String> {


    @Override
    public String process(String item) throws Exception {
    String task1Processor = "Processing 1 :"+item;
        return task1Processor;
    }
}