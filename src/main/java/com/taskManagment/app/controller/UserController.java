package com.taskManagment.app.controller;


import com.taskManagment.app.controller.dto.UserDto;
import com.taskManagment.app.controller.dto.UserDtoMapper;
import com.taskManagment.app.entity.MyUser;
import com.taskManagment.app.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {




        private UserService service;


        public UserController(UserService service) {
        this.service = service;
    }

        @GetMapping("/tasks")
        public List<MyUser> getUsersWithTasks() {
            return service.getAll();
        }

        @GetMapping("")
        public List<UserDto> getUsers() {
            return UserDtoMapper.mapToUserDtos(service.getAll());
        }


        @GetMapping("/{id}")
        public MyUser getUserById(@PathVariable long id) {
            return service.getById(id);
        }


        @PostMapping("")
        public MyUser addUser(@RequestBody MyUser user) {
            return service.addUser(user);

        }

        @PutMapping("")
        public MyUser editUser(@RequestBody MyUser user) {
            return service.editUser(user);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable long id) {
            service.deleteUser(id);

        }

        }




