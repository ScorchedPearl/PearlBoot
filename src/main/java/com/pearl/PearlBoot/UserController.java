package com.pearl.PearlBoot;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public User createUser(
           @RequestBody User user
    ) {
        return userRepository.save(user);
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/users/search/{name}")
    public List<User> searchUsers(
            @PathVariable("name") String name) {
        return userRepository.findAllByNameContaining(name);
    }
    @DeleteMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(
            @PathVariable("userId") Integer userId) {
        userRepository.deleteById(userId);
    }
}
