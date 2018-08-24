package com.nikhilgupta.buisness;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.nikhilgupta.api.TodoService;
import com.nikhilgupta.api.TodoServiceStub;
import com.nikhilgupta.buisness.TodoBuisnessImpl;

public class TodoBuisnessImplStub {

	@Test
	public void testRetreiveTodosRelatedToString_usingAStub() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBuisnessImpl todoBuisnessImpl = 
				new TodoBuisnessImpl(todoServiceStub);
		
		List<String> filteredTodos = todoBuisnessImpl.retreiveTodosRelatedToSpring("Dummy");
		
		assertEquals(1,filteredTodos.size());	
		
		
	}

}
