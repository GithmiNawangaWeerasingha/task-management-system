package com.example.TaskManagemmentSystem.service.impl;

import com.example.TaskManagemmentSystem.dto.PublicUserDto;
import com.example.TaskManagemmentSystem.dto.TaskDto;
import com.example.TaskManagemmentSystem.entity.PublicUser;
import com.example.TaskManagemmentSystem.entity.Task;
import com.example.TaskManagemmentSystem.repository.PublicUserRepository;
import com.example.TaskManagemmentSystem.repository.TaskRepository;
import com.example.TaskManagemmentSystem.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private PublicUserRepository publicUserRepository;

    @Override
    public TaskDto saveTask(TaskDto taskDto) {

        PublicUser publicUser = publicUserRepository.findById(taskDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = new Task();
        task.setDescription(taskDto.getDescription());
        task.setCompleted(false);
        task.setPublicUser(publicUser);

        task = taskRepository.save(task);
        taskDto.setId(task.getId());
        taskDto.setCompleted(task.getCompleted());
        return taskDto;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();

        return tasks.stream().map(task -> new TaskDto(task.getId(), task.getDescription(), task.getCompleted(), task.getPublicUser().getId())).collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getAllTasksByUser(int userId) {

        PublicUser publicUser = publicUserRepository.findById(userId).orElse(null);

        if (publicUser == null) {
            throw new RuntimeException("Invalid User Id");
        }else{
            List<Task> tasks = taskRepository.findAllByPublicUser(publicUser);

            return tasks.stream().map(task -> new TaskDto(task.getId(), task.getDescription(), task.getCompleted(), task.getPublicUser().getId())).collect(Collectors.toList());
        }


    }

    @Override
    public void deleteTask(int taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        Task task = taskRepository.findById(taskDto.getId())
                .orElseThrow(() -> new RuntimeException("Task not found"));


        task.setCompleted(taskDto.getCompleted());
        task.setDescription(taskDto.getDescription());
        task.setPublicUser(task.getPublicUser());

        task = taskRepository.save(task);
        taskDto.setUserId(task.getPublicUser().getId());
        return taskDto;

    }
}
