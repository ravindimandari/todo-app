package com.example.backend.service;

import com.example.backend.entity.TodoEntity;
import com.example.backend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public TodoEntity createTask(TodoEntity task){
        task.setCreatedAt(LocalDateTime.now());
        return todoRepository.save(task);
    }

    public List<TodoEntity> getRecentTasks(){
        List<TodoEntity> allTasks= StreamSupport
                .stream(todoRepository.findAll().spliterator(),false)
                .filter(task ->!task.isCompleted())
                .sorted(Comparator.comparing(TodoEntity::getCreatedAt).reversed())
                .limit(5)
                .collect(Collectors.toList());

        return allTasks;
    }

    public void completeTask(Integer id){
        Optional <TodoEntity> taskOpt=todoRepository.findById(id);
        taskOpt.ifPresent(task -> {
            task.setCompleted(true);
            todoRepository.save(task);
        });
    }




}
