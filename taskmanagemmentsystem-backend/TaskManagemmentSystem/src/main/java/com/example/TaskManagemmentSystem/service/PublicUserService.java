package com.example.TaskManagemmentSystem.service;

import com.example.TaskManagemmentSystem.dto.PublicUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublicUserService {

    PublicUserDto registerUser(PublicUserDto publicUserDto);
    PublicUserDto updateUser(PublicUserDto publicUserDto);

    List<PublicUserDto> getAllUsers();

    void deleteUser(int id);

}
