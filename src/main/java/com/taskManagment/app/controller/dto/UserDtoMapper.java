package com.taskManagment.app.controller.dto;

import com.taskManagment.app.entity.MyUser;

import java.util.List;
import java.util.stream.Collectors;

public class UserDtoMapper {


    private UserDtoMapper() {
    }


    public static List<UserDto> mapToUserDtos(List<MyUser> users) {
        return users.stream().map(myUser -> mapToUserDto(myUser))
                .collect(Collectors.toList());

    }

    private static UserDto mapToUserDto(MyUser user) {
        return UserDto.builder().id(user.getId())
                .username(user.getUsername())
                .build();

    }
}