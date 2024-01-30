package com.example.TaskManagemmentSystem.controller;

import com.example.TaskManagemmentSystem.dto.PublicUserDto;
import com.example.TaskManagemmentSystem.dto.TaskDto;
import com.example.TaskManagemmentSystem.repository.TaskRepository;
import com.example.TaskManagemmentSystem.entity.Task;
import com.example.TaskManagemmentSystem.service.TaskService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/save")
    public ResponseEntity<Object> saveTask(@RequestBody TaskDto taskDto) {
        try {
            TaskDto result = taskService.saveTask(taskDto);
            return ResponseEntity.ok().body(Map.of("message", "Task Saved Successfully", "result", result));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAllTasks() {
        try {
            List<TaskDto> result = taskService.getAllTasks();
            return ResponseEntity.ok().body(Map.of("message", "Tasks Retrieved Successfully", "result", result));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/get-all/{id}")
    public ResponseEntity<Object> getAllTasksByUser(@PathVariable(value = "id") int userId) {
        try {
            List<TaskDto> result = taskService.getAllTasksByUser(userId);
            return ResponseEntity.ok().body(Map.of("message", "Tasks Retrieved Successfully", "result", result));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") int taskId) {
        try {
            taskService.deleteTask(taskId);
            return ResponseEntity.ok().body(Map.of("message", "Tasks Deleted Successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Object> updateTask(@RequestBody TaskDto taskDto){
        try {
            TaskDto result = taskService.updateTask(taskDto);
            return ResponseEntity.ok().body(Map.of("message", "Tasks Updated Successfully", "result", result));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
