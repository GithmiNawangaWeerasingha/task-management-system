package com.example.TaskManagemmentSystem.service;

import com.example.TaskManagemmentSystem.dto.PublicUserDto;
import com.example.TaskManagemmentSystem.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    TaskDto saveTask(TaskDto taskDto);

    List<TaskDto> getAllTasks();

    List<TaskDto> getAllTasksByUser(int userId);

    void deleteTask(int taskId);
    TaskDto updateTask(TaskDto taskDto);

}
