package com.taskManagment.app.controller;


import com.taskManagment.app.entity.Task;
import com.taskManagment.app.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {




    private UserService service;

    public TaskController(UserService service) {
        this.service = service;
    }


    @GetMapping("")
    public List<Task> getAll() {
        return service.getAllTasks();

    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable long id) {
        return service.getTaskById(id);

    }

    @PostMapping("")
    public Task add(@RequestBody Task task) {
        return service.addTask(task);
    }

    @PutMapping("")
    public Task edit(@RequestBody Task task) {
        return service.editTask(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        service.deleteTask(id);
    }



    }

