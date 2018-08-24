package com.nikhilgupta.buisness;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void letsMockListSizeMethod() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		
		assertEquals(2,listMock.size());
	}
	
	@Test
	public void letsMockListSize_ReturnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		
		assertEquals(2,listMock.size());
		assertEquals(3,listMock.size());
	}
	
	@Test
	public void letsMockListGet() {
		List listMock = mock(List.class);
		
		//Argument Matcher
		when(listMock.get(anyInt())).thenReturn("nikhil");
		
		assertEquals("nikhil",listMock.get(0));
		assertEquals(null,listMock.get(1));
	}
	
	@Test
	public void letsMockListGet_usingBDD() {
		
		//Given
		List listMock = mock(List.class);
			//Argument Matcher
		given(listMock.get(anyInt())).willReturn("nikhil");
		
		//when
		String firstElement = (String) listMock.get(0);
		
		//Then
		assertThat(firstElement, is("nikhil"));
	}
	
	@Test(expected=RuntimeException.class)
	public void letsMockList_throwAnException() {
		List listMock = mock(List.class);
		
		//Argument Matcher
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
		
		listMock.get(0);
	}


}
