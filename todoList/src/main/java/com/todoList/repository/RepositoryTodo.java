package com.todoList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoList.entity.Todos;

@Repository
public interface RepositoryTodo extends JpaRepository<Todos, Integer>{
	public Todos getById(Integer id);
}
