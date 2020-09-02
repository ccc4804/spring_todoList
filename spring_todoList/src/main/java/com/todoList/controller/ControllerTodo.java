package com.todoList.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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

	private static Log log = LogFactory.getLog(ControllerTodo.class);
	
	@GetMapping(value = "/list")
	public Object getList() {
		getAccessIp();
		return gson.toJson(serviceTodo.getTodo());
	}
	
	@PostMapping(value = "/add")
	public String postTodo(@RequestBody PostRequestBodyTodo rqt) {
		getAccessIp();
		return serviceTodo.postTodo(rqt);
	}
	
	@DeleteMapping(value = "/remove")
	public String deleteTodo(@RequestBody DeleteRequestBodyTodo rqt) {
		getAccessIp();
		return serviceTodo.deleteTodo(rqt);
	}
	
	public void getAccessIp() {
		HttpServletRequest req = 
				((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
        String accessIp = req.getHeader("X-FORWARDED-FOR");
        if (accessIp == null) {
        	accessIp = req.getRemoteAddr();
        }
        
        log.info("server access ip : " + accessIp);
	}
}
