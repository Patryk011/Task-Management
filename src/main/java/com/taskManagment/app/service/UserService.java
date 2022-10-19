package com.taskManagment.app.service;




import com.taskManagment.app.entity.MyUser;
import com.taskManagment.app.entity.Task;
import com.taskManagment.app.repository.TaskRepository;
import com.taskManagment.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {


    private UserRepository userRepository;
    private TaskRepository taskRepository;

    public UserService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }


    public List<MyUser> getAll() {
        return userRepository.findAll();
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public MyUser getById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException());

    }
    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }


    public MyUser addUser(MyUser user) {
        return userRepository.save(user);
    }


  public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Transactional
    public MyUser editUser(MyUser user) {
        MyUser editedUser = userRepository.findById(user.getId()).orElseThrow(() -> new NoSuchElementException());
        editedUser.setUsername(user.getUsername());
        return editedUser;
    }


    @Transactional
    public Task editTask(Task task) {
        Task editedTask = taskRepository.findById(task.getId()).orElseThrow(() -> new NoSuchElementException());
        editedTask.setContent(task.getContent());
        editedTask.setCompleted(task.getCompleted());
        return editedTask;
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }
}
