package com.example.taskdemo;

import com.example.taskdemo.data.Compte;
import com.example.taskdemo.data.CompteRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
class Task2ItemReader implements ItemReader<String> {

    private List<Compte> comptes;
    private int i, count;
    @Autowired
    private CompteRepo compteRepo;


    //@PostConstruct
    @BeforeStep
    public void init () {
        this.comptes = getComptes();
        this.i = 0;
        this.count = comptes.size();
    }
    //private Boolean canRead = true;
    @Override
    public String read() throws Exception {
//        if(!canRead)
//            return null;
//        canRead = false;
//        String taskReader = "reader: 2";
//
//        System.out.println(taskReader);
//        return taskReader;

            if (i == count)
                return null;
            String taskReader = this.comptes.get(i).getNom();
            i++;
            System.out.println("reader 2 : "+taskReader);
            return taskReader;
        }

        public List<Compte> getComptes(){
            return compteRepo.findAll();
        }
}