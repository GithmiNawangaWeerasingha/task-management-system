package com.example.TaskManagemmentSystem.controller;

import com.example.TaskManagemmentSystem.repository.TaskRepository;
import com.example.TaskManagemmentSystem.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @PostMapping("/save-task")
    public String saveTask(@RequestBody Task task){
        return "Task Saved Successfully";
    }

}
