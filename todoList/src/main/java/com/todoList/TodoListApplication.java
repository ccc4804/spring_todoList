package com.todoList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TodoListApplication extends SpringBootServletInitializer {

	public static void main (String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		//return super.configure(builder);
		return builder.sources(TodoListApplication.class);
	}

}
