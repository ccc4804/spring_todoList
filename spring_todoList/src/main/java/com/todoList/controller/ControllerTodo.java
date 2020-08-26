package com.todoList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.todoList.data.DeleteRequestBodyTodo;
import com.todoList.data.PostRequestBodyTodo;
import com.todoList.entity.Todo;
import com.todoList.service.ServiceTodo;

@RestController
@CrossOrigin(origins = "*")
public class ControllerTodo {
	@Autowired
	ServiceTodo serviceTodo;
	@Autowired
	Gson gson;	
	
	@GetMapping(value = "/list")
	public Object getList() {
		return gson.toJson(serviceTodo.getTodo());
	}
	
	@PostMapping(value = "/add")
	public String postTodo(@RequestBody PostRequestBodyTodo rqt) {
		return serviceTodo.postTodo(rqt);
	}
	
	@DeleteMapping(value = "/remove")
	public String deleteTodo(@RequestBody DeleteRequestBodyTodo rqt) {
		return serviceTodo.deleteTodo(rqt);
	}
}
