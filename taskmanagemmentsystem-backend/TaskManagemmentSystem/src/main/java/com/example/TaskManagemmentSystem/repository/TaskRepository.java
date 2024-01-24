package com.example.TaskManagemmentSystem.repository;

import com.example.TaskManagemmentSystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
