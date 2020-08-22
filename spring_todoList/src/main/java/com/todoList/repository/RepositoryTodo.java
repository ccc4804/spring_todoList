package com.todoList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoList.entity.Todo;
import com.todoList.entity.TodoPK;

public interface RepositoryTodo extends JpaRepository<Todo, TodoPK>{
}
