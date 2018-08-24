package com.nikhilgupta.buisness;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.nikhilgupta.api.TodoService;
import com.nikhilgupta.api.TodoServiceStub;
import com.nikhilgupta.buisness.TodoBuisnessImpl;

public class TodoBuisnessImplMockTest {

	@Test
	public void testRetreiveTodosRelatedToString_usingAMock() {
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos =Arrays.asList("Learn spring mvc","Learn to sketch","Learn to dance");
		
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		
		TodoBuisnessImpl todoBuisnessImpl = 
				new TodoBuisnessImpl(todoServiceMock);
		
		List<String> filteredTodos = todoBuisnessImpl.retreiveTodosRelatedToSpring("Dummy");
		
		assertEquals(1,filteredTodos.size());	
		
		
	}
	

	@Test
	public void testRetreiveTodosRelatedToString_usingBDD() {
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos =Arrays.asList("Learn spring mvc","Learn to sketch","Learn to dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		
		TodoBuisnessImpl todoBuisnessImpl = 
				new TodoBuisnessImpl(todoServiceMock);
		
		//When
		List<String> filteredTodos = todoBuisnessImpl.retreiveTodosRelatedToSpring("Dummy");
		
		//Then
		assertThat(filteredTodos.size(), is(2));	
		
		
	}
	
	@Test
	public void testdeleteTodosNotRelatedToString_usingBDD() {
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos =Arrays.asList("Learn spring mvc","Learn spring to sketch","Learn to dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		
		TodoBuisnessImpl todoBuisnessImpl = 
				new TodoBuisnessImpl(todoServiceMock);
		
		//When
		todoBuisnessImpl.deleteTodosRelatedToSpring("Dummy");
		
		//Then
		verify(todoServiceMock,atLeast(5)).deleteTodo("Learn to dance");
		
		verify(todoServiceMock,times(1)).deleteTodo("Learn to dance");
		
		verify(todoServiceMock).deleteTodo("Learn to dance");
		//then(todoServiceMock).should().deleteTodo(("Learn to dance");
		
		verify(todoServiceMock,never()).deleteTodo("Learn spring mvc");
		//then(todoServiceMock).should(never()).deleteTodo(("Learn to dance");
	}
	

	@Test
	public void testdeleteTodosNotRelatedToString_usingBDD_argumentCapture() {
		
		//Declare Argument capture
		ArgumentCaptor<String> stringArgumentCapture = ArgumentCaptor.forClass(String.class);
		
		//Define argument capture on specific method call
		//capture the argument
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos =Arrays.asList("Learn spring mvc","Learn spring to sketch","Learn to dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		
		TodoBuisnessImpl todoBuisnessImpl = 
				new TodoBuisnessImpl(todoServiceMock);
		
		//When
		todoBuisnessImpl.deleteTodosRelatedToSpring("Dummy");
		
		//Then
		then(todoServiceMock).should().deleteTodo(stringArgumentCapture.capture());
		assertThat(stringArgumentCapture.getValue(), is("Learn to dance"));
	}
	
	@Test
	public void testdeleteTodosNotRelatedToString_usingBDD_multipleArgumentCapture() {
		
		//Declare Argument capture
		ArgumentCaptor<String> stringArgumentCapture = ArgumentCaptor.forClass(String.class);
		
		//Define argument capture on specific method call
		//capture the argument
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos =Arrays.asList("Learn mvc","Learn spring to sketch","Learn to dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		
		TodoBuisnessImpl todoBuisnessImpl = 
				new TodoBuisnessImpl(todoServiceMock);
		
		//When
		todoBuisnessImpl.deleteTodosRelatedToSpring("Dummy");
		
		//Then
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCapture.capture());
		assertThat(stringArgumentCapture.getAllValues().size(), is(2));
	}


}
