package com.example.reactive.util.mapper;

import org.mapstruct.factory.Mappers;

public class MapperConstants {
    private MapperConstants() {
    }

    public static final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
}
