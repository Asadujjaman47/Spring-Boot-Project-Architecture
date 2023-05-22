package com.asad.controller;

import com.asad.dto.UserDto;
import com.asad.entity.User;
import com.asad.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // build create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto savedUser = userService.createUser(user);

        return ResponseEntity.ok(savedUser);
    }

    // build get user by id REST API
    // http://localhost:8093/api/users/ID
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto user = userService.getUserById(userId);

        return ResponseEntity.ok(user);
    }

    // Get All Users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    // Build Update User Rest API
    // http://localhost:8093/api/users/ID
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody UserDto user) {
        user.setId(userId);
        UserDto updateUser = userService.updateUser(user);

        return ResponseEntity.ok(updateUser);
    }

    // Build Delete User REST API
//    http://localhost:8093/api/users/ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);

        return ResponseEntity.ok("User successfully Deleted!");
    }


}
