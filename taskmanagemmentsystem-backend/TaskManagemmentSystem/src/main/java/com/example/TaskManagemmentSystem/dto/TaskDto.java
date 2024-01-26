package com.example.TaskManagemmentSystem.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TaskDto {
    private int id;
    private String description;
    private Boolean completed;
    private int userId;
}
