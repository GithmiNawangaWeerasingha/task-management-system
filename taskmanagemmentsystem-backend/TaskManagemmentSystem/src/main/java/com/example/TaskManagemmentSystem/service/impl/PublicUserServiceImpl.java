package com.example.TaskManagemmentSystem.service.impl;

import com.example.TaskManagemmentSystem.dto.PublicUserDto;
import com.example.TaskManagemmentSystem.entity.PublicUser;
import com.example.TaskManagemmentSystem.repository.PublicUserRepository;
import com.example.TaskManagemmentSystem.service.PublicUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublicUserServiceImpl implements PublicUserService {

    @Autowired
    private PublicUserRepository publicUserRepository;
    @Override
    public PublicUserDto registerUser(PublicUserDto publicUserDto) {
        boolean emailExists = publicUserRepository.existsByEmail(publicUserDto.getEmail());
        if (emailExists) {
            throw new RuntimeException("Invalid Email");
        }else {
            PublicUser publicUser = new PublicUser();
            publicUser.setName(publicUserDto.getName());
            publicUser.setEmail(publicUserDto.getEmail());
            publicUser.setPassword(publicUserDto.getPassword());

            publicUser = publicUserRepository.save(publicUser);
            publicUserDto.setId(publicUser.getId());
            return publicUserDto;
        }
    }

    @Override
    public PublicUserDto updateUser(PublicUserDto publicUserDto) {
        boolean userExists = publicUserRepository.existsById(publicUserDto.getId());
        if (!userExists) {
            throw new RuntimeException("Invalid User Id");
        }else {
            PublicUser publicUser = new PublicUser();
            publicUser.setId(publicUserDto.getId());
            publicUser.setName(publicUserDto.getName());
            publicUser.setEmail(publicUserDto.getEmail());
            publicUser.setPassword(publicUserDto.getPassword());

            publicUser = publicUserRepository.save(publicUser);
            return publicUserDto;
        }
    }

    @Override
    public List<PublicUserDto> getAllUsers() {
        List<PublicUser> publicUsers = publicUserRepository.findAll();

        return publicUsers.stream().map(publicUser -> new PublicUserDto(publicUser.getId(), publicUser.getName(), publicUser.getEmail())).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(int id) {
        PublicUser publicUser = publicUserRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        publicUserRepository.delete(publicUser);
    }
}
