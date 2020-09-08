package com.todoList.service;

import java.util.List;
import java.util.Map;

import com.todoList.data.DeleteRequestBodyTodo;
import com.todoList.data.PostRequestBodyTodo;
import com.todoList.entity.Todos;

public interface ServiceTodo {
	Map<String, List<Todos>> getTodo();
	String postTodo(PostRequestBodyTodo rqt);
	String deleteTodo(DeleteRequestBodyTodo rqt);
}
