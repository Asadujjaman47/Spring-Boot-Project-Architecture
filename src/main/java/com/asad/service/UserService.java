package com.asad.service;

import com.asad.dto.UserDto;
import com.asad.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);


    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);
}
