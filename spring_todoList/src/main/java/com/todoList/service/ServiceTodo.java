package com.todoList.service;

import java.util.List;

import com.todoList.data.DeleteRequestBodyTodo;
import com.todoList.data.PostRequestBodyTodo;
import com.todoList.entity.Todo;

public interface ServiceTodo {
	List<Todo> getTodo();
	String postTodo(PostRequestBodyTodo rqt);
	String deleteTodo(DeleteRequestBodyTodo rqt);
}
