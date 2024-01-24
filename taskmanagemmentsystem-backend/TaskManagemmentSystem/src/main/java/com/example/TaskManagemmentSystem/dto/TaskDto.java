package com.example.TaskManagemmentSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDto {
    private int id;
    private String description;
    private Boolean completed;
    private UserDto userDetails;
}
