package com.example.backend.repository;


import com.example.backend.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<TodoEntity,Integer> {

}
