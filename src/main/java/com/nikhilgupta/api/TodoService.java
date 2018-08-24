package com.nikhilgupta.api;

import java.util.List;

//create TodoService stub
//Test TodoBuisnessImpl using TodoServicestub
public interface TodoService {
	
	public List<String> retrieveTodos(String user);
	public void deleteTodo(String todo);

}
