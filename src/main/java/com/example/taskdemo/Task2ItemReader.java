package com.example.taskdemo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class Task2ItemReader implements ItemReader<String> {


    private Boolean canRead = true;
    @Override
    public String read() throws Exception {
        if(!canRead)
            return null;
        canRead = false;
        String taskReader = "reader: 2";

        System.out.println(taskReader);
        return taskReader;
    }


}