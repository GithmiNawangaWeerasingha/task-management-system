package com.example.TaskManagemmentSystem.controller;

import com.example.TaskManagemmentSystem.repository.TaskRepository;
import com.example.TaskManagemmentSystem.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @PostMapping("/save")
    public String saveTask(@RequestBody Task task){
        return "Task Saved Successfully";
    }

}
