package com.todoList.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoList.data.DeleteRequestBodyTodo;
import com.todoList.data.PostRequestBodyTodo;
import com.todoList.entity.Todos;
import com.todoList.repository.RepositoryTodo;

@Service
public class ServiceTodoImpl implements ServiceTodo{
	@Autowired
	RepositoryTodo repositoryTodo;
	@Autowired
	EntityManager entityManager;	

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Map<String, List<Todos>> getTodo() {
		List<Todos> todoList;

		todoList = repositoryTodo.findAll();
		
		Map<String, List<Todos>> response = new HashMap<>();
		response.put("data", todoList);
		logger.info("response" + response.toString());
		
		return response;
	}
	
	@Override
	@Transactional
	public String postTodo(PostRequestBodyTodo rqt) {
		try {
			//Todos exist = repositoryTodo.findByPK(new TodoPK(rqt.getUser(), rqt.getId()));
			if(entityManager.find(Todos.class, rqt.getId()) == null) {
				Todos insertTodo = new Todos(rqt.getId(),rqt.getText(),false);
				repositoryTodo.save(insertTodo);
				//entityManager.persist(insertTodo);
			}else {
				logger.error("Todo is exist!");
				throw new Exception("Todo is exist!");
			}
		}catch (Exception e) {
			logger.error("error: " + e.toString());
			return "error: " + e.toString();
		}
		logger.info("[postTodo] success");
		return "SUCCESS";
	}

	@Override
	@Transactional
	public String deleteTodo(DeleteRequestBodyTodo rqt) {
		try {
			Todos exist = entityManager.find(Todos.class, rqt.getId());
			if(exist != null) {
				entityManager.remove(exist);
			}else {
				logger.error("Todo is exist!");
				throw new Exception("Todo is not exist!");
			}
		}catch (Exception e) {
			logger.error("error: " + e.toString());
			return "error: " + e.toString();
		}
		logger.info("[deleteTodo] success");
		return "SUCCESS";
	}
}
