package com.example.reactive.controller;

import com.example.reactive.dto.UserDTO;
import com.example.reactive.dto.UserRequestDTO;
import com.example.reactive.entity.User;
import com.example.reactive.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private Flux<UserDTO> findAll() {
        return userService.findAll();
    }

    @PostMapping
    private Mono<UserDTO> create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("/{id}")
    private Mono<UserDTO> update(@PathVariable String id, @RequestBody UserRequestDTO userRequestDTO){
        return userService.update(id, userRequestDTO);
    }

    @DeleteMapping("/{id}")
    private Mono<Void> delete(@PathVariable String id){
        return userService.delete(id);
    }
}
