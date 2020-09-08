package com.todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoList.entity.Todos;

@Repository
public interface RepositoryTodo extends JpaRepository<Todos, Integer>{

}
