package com.asad.service;

import com.asad.entity.User;
import com.asad.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);

        return updatedUser;
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }
}
