package com.example.TaskManagemmentSystem.repository;

import com.example.TaskManagemmentSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
