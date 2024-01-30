package com.example.TaskManagemmentSystem.controller;

import com.example.TaskManagemmentSystem.dto.PublicUserDto;
import com.example.TaskManagemmentSystem.service.PublicUserService;
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
@RequestMapping(value = "/user")
public class PublicUserController {

    @Autowired
    private PublicUserService publicUserService;

    @PostMapping("/save")
    public ResponseEntity<Object> registerUser(@RequestBody PublicUserDto publicUserDto) {
        try {
            PublicUserDto result = publicUserService.registerUser(publicUserDto);
            return ResponseEntity.ok().body(Map.of("message", "User Saved Successfully", "result", result));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Object> updateUser(@RequestBody PublicUserDto publicUserDto) {
        try {
            PublicUserDto result = publicUserService.updateUser(publicUserDto);
            return ResponseEntity.ok().body(Map.of("message", "User Update Successfully", "result", result));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user");
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity getAllUsers() {
        try {
            List<PublicUserDto> result = publicUserService.getAllUsers();
            return ResponseEntity.ok().body(Map.of("message", "Users Get Successfully", "result", result));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting users");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable(value = "id") int id) {
        try {
            publicUserService.deleteUser(id);
            return ResponseEntity.ok().body(Map.of("message", "User Deleting Successfully"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
