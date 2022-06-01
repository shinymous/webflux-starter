package com.example.reactive.util.mapper;

import com.example.reactive.dto.UserDTO;
import com.example.reactive.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO buildUserDTO(User user);
}
