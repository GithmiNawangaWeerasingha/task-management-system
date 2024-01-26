package com.example.TaskManagemmentSystem.dto;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PublicUserDto {
    private int id;
    private String name;
    private String email;
    private String password;

    private List<TaskDto> tasks;

    public PublicUserDto(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    };
}
