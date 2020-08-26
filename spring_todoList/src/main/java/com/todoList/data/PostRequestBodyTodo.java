package com.todoList.data;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestBodyTodo {
	private int id;
	private String text;
	private boolean done = false;
}
