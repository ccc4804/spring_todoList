package com.todoList.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.todoList.data.DeleteRequestBodyTodo;
import com.todoList.data.PostRequestBodyTodo;
import com.todoList.entity.Todos;
import com.todoList.repository.RepositoryTodo;
import com.todoList.service.ServiceTodo;

@RestController
@CrossOrigin(origins = "*")
public class ControllerTodo {
	@Autowired
	ServiceTodo serviceTodo;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;
	@Autowired
	RepositoryTodo repositoryTodo;

	@GetMapping(value = "/list")
	public Object getList() {
		getAccessIp();
		// return gson.toJson(serviceTodo.getTodo());
		List<Todos> todoList;

		todoList = repositoryTodo.findAll();
		
		Map<String, List<Todos>> response = new HashMap<>();
		response.put("data", todoList);
		logger.info("response" + response.toString());

		return serviceTodo.getTodo();
	}

	@PostMapping(value = "/add")
	public String postTodo(@RequestBody PostRequestBodyTodo rqt) {
		//getAccessIp();
		return serviceTodo.postTodo(rqt);
	}
	
	@DeleteMapping(value = "/remove")
	public String deleteTodo(@RequestBody DeleteRequestBodyTodo rqt) {
		//getAccessIp();
		return serviceTodo.deleteTodo(rqt);
	}

	public void getAccessIp() {
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		String accessIp = req.getHeader("X-FORWARDED-FOR");
		if (accessIp == null) {
			accessIp = req.getRemoteAddr();
		}

		logger.info("server access ip : " + accessIp);
	}
}
