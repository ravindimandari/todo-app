package com.example.backend.controller;

import com.example.backend.entity.TodoEntity;
import com.example.backend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/tasks")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public TodoEntity createTask(@RequestBody TodoEntity task){
        return todoService.createTask(task);
    }

    @GetMapping
    public List<TodoEntity> getRecentTasks(){
        return todoService.getRecentTasks();
    }

    @PutMapping("/{id}/complete")
    public void completeTask(@PathVariable Integer id){
        todoService.completeTask(id);
    }



}
