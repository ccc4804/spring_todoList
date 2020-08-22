package com.todoList.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.todoList.data.DeleteRequestBodyTodo;
import com.todoList.data.PostRequestBodyTodo;
import com.todoList.entity.Todo;
import com.todoList.entity.TodoPK;
import com.todoList.repository.RepositoryTodo;

@Service
public class ServiceTodoImpl implements ServiceTodo{
	@Autowired
	RepositoryTodo repositoryTodo;
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Todo> getTodo() {
		List<Todo> todoList;
		
		todoList = repositoryTodo.findAll();
		
		return todoList;
	}
	
	@Override
	@Transactional
	public String postTodo(PostRequestBodyTodo rqt) {
		try {
			Todo exist = entityManager.find(Todo.class, new TodoPK(rqt.getUser(), rqt.getId()));
					//repositoryTodo.findByPK(new TodoPK(rqt.getUser(), rqt.getId()));
			if(exist==null) {
				Todo insertTodo = new Todo(rqt.getUser(),rqt.getId(),rqt.getText(),false);
				//repositoryTodo.save(insertTodo);
				entityManager.persist(insertTodo);
			}else {
				throw new Exception("Todo is exist!");
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "error: " + e.toString();
		}
		return "SUCCESS";
	}

	@Override
	@Transactional
	public String deleteTodo(DeleteRequestBodyTodo rqt) {
		try {
			Todo exist = entityManager.find(Todo.class, new TodoPK(rqt.getUser(), rqt.getId()));
			if(exist != null) {
				entityManager.remove(exist);
			}else {
				throw new Exception("Todo is not exist!");
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "error: " + e.toString();
		}
		return "SUCCESS";
	}

}
