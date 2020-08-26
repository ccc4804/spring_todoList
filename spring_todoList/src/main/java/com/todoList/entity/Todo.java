package com.todoList.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@IdClass(TodoPK.class)
@Table(name = "TODOS")
public class Todo implements Serializable {
//	@Id
//	private String user;
	@Id
	private int id;
	@NotNull
	private String text;
	@NotNull
	private boolean done = false;
}
