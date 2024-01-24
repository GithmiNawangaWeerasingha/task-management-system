package com.example.TaskManagemmentSystem.controller;

import com.example.TaskManagemmentSystem.entity.Task;
import com.example.TaskManagemmentSystem.entity.User;
import com.example.TaskManagemmentSystem.repository.TaskRepository;
import com.example.TaskManagemmentSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @PostMapping("/save-user")
    public String saveUser(@RequestBody User user){
        return "User Saved Successfully";
    }

}
