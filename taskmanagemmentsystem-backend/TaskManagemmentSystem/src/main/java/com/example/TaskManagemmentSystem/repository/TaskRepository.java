package com.example.TaskManagemmentSystem.repository;

import com.example.TaskManagemmentSystem.entity.PublicUser;
import com.example.TaskManagemmentSystem.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findAllByPublicUser(PublicUser publicUser);
}
