package com.example.taskdemo;

import com.example.taskdemo.data.Compte;
import com.example.taskdemo.data.CompteRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Slf4j
@Component
public class Task2ItemWriter implements ItemWriter<String> {

    @Autowired
    CompteRepo compteRepo;
    @Override
    public void write(List<? extends String> items) throws Exception {
        items.forEach(item -> System.out.println("Writing 2 : "+ item));
    }
}
