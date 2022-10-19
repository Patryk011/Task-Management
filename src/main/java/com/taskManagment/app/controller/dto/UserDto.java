package com.taskManagment.app.controller.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {


    private long id;
    private String username;

}
