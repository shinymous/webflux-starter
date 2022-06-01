package com.example.reactive.service;

import com.example.reactive.dto.UserDTO;
import com.example.reactive.dto.UserRequestDTO;
import com.example.reactive.entity.User;
import com.example.reactive.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.reactive.util.mapper.MapperConstants.userMapper;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<UserDTO> findAll(){
        return userRepository.findAll().map(userMapper::buildUserDTO);
    }

    public Mono<UserDTO> create(final User user){
        return userRepository.save(user).map(userMapper::buildUserDTO);
    }

    private Mono<User> findById(final String id){
        return userRepository.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.MULTI_STATUS, "User not found")));
    }

    public Mono<UserDTO> update(final String id, final UserRequestDTO userRequestDTO){
        Mono<User> userMono = this.findById(id);
        return userMono.flatMap(user -> Mono.just(user.withName(userRequestDTO.name())
                        .withEmail(userRequestDTO.email())))
                .flatMap(userRepository::save)
                .map(userMapper::buildUserDTO);
    }

    public Mono<Void> delete(final String id){
        return this.findById(id).flatMap(userRepository::delete);
    }
}
