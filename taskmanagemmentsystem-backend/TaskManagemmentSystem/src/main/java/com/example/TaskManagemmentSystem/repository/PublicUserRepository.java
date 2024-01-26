package com.example.TaskManagemmentSystem.repository;

import com.example.TaskManagemmentSystem.entity.PublicUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicUserRepository extends JpaRepository<PublicUser, Integer> {
    boolean existsByEmail(String email);
    boolean existsById(Integer id);
}
