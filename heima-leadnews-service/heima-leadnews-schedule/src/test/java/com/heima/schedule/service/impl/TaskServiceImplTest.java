package com.heima.schedule.service.impl;

import com.heima.model.schedule.dtos.Task;
import com.heima.schedule.ScheduleApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.soap.SAAJResult;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = ScheduleApplication.class)
@RunWith(SpringRunner.class)
class TaskServiceImplTest {

    @Autowired
    private TaskServiceImpl taskService;

    @Test
    void addTask() {
        for (int i = 0; i < 5; i++){

            Task task = new Task();
            task.setTaskType(100+i);
            task.setPriority(50);
            task.setParameters("hello".getBytes());
            task.setExecuteTime(new Date().getTime()+500*i);

            long taskId = taskService.addTask(task);
            System.out.println(taskId);
        }
//        Task task = new Task();
//        task.setTaskType(100);
//        task.setPriority(50);
//        task.setParameters("hello".getBytes());
//        task.setExecuteTime(new Date().getTime()+5000);
//
//        long taskId = taskService.addTask(task);
//        System.out.println(taskId);
    }

    @Test
    void cancelTask() {
        boolean b = taskService.cancelTask(1960980709921267713L);
        System.out.println(b);
    }

    @Test
    void poll() {
        Task poll = taskService.poll(100, 50);
        System.out.println(poll);
    }

}