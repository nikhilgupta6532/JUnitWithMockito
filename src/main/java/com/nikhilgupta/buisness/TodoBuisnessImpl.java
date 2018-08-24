package com.nikhilgupta.buisness;

import java.util.ArrayList;
import java.util.List;

import com.nikhilgupta.api.TodoService;

//TodoBuisnessImpl SUT(System under test)
//TodoService Dependency

public class TodoBuisnessImpl {
	
	private TodoService todoService;

	public TodoBuisnessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	public List<String> retreiveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String>todos = todoService.retrieveTodos(user);
		for(String todo: todos) {
			if(todo.contains("spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void deleteTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String>todos = todoService.retrieveTodos(user);
		for(String todo: todos) {
			if(!todo.contains("spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}
	

}
