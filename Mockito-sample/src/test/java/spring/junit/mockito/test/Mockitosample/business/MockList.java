package spring.junit.mockito.test.Mockitosample.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class MockList {
	List<String> mock = mock(List.class);
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void list_size_basic() {
		
		when(mock.size()).thenReturn(5);
		assertEquals(5,mock.size());
	}
	@Test
	public void list_different_size() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,mock.size());
		assertEquals(10,mock.size());
	}
	
	@Test
	public void list_return_diffparams() {
		when(mock.get(0)).thenReturn("hello world");
		assertEquals("hello world",mock.get(0));
		assertEquals(null,mock.get(1));
	}
	@Test
	public void list_return_genericparams() {
		when(mock.get(anyInt())).thenReturn("hello world");
		assertEquals("hello world",mock.get(0));
		assertEquals("hello world",mock.get(1));
	}
	
	@Test
	public void verify_method_calls() {
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		//Verify if the methods are called
		verify(mock).get(0);
		verify(mock).get(1);
		verify(mock,times(2)).get(anyInt());
		verify(mock,atLeast(1)).get(0);
		verify(mock,atLeastOnce()).get(1);
		verify(mock,atMost(2)).get(anyInt());
		verify(mock,never()).get(2);
	}
	
	@Test
	public void verify_argument_capturing() {
		mock.add("add Something");
		
		//verify wat the value is passed
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		assertEquals("add Something", captor.getValue());
	}
	
	@Test
	public void verify_multiple_argument_capturing() {
		mock.add("add Something1");
		mock.add("add Something2");
		
		//verify wat the value is passed
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock,times(2)).add(captor.capture());
		List<String> allValues = captor.getAllValues();
		assertEquals("add Something1", allValues.get(0));
		assertEquals("add Something2", allValues.get(1));
	}
	
	@Test
	public void mocking() {
		ArrayList arrayList = mock(ArrayList.class);
		System.out.println(arrayList.get(0)); //0
		System.out.println(arrayList.size()); //0
		
		arrayList.add("Test1");
		arrayList.add("Test2");
		
		System.out.println(arrayList.size());
		
		when(arrayList.size()).thenReturn(5);
		
		System.out.println(arrayList.size());
		arrayList.add("Test3");
		
		System.out.println(arrayList.size());
		
	}
	
	
	@Test
	public void spying() {
		ArrayList arrayList = spy(ArrayList.class);
		
		arrayList.add("test0");
		System.out.println(arrayList.get(0)); //0
		System.out.println(arrayList.size()); //0
		
		arrayList.add("Test1");
		arrayList.add("Test2");
		
		System.out.println(arrayList.size());
		
		when(arrayList.size()).thenReturn(5);
		
		System.out.println(arrayList.size());
		arrayList.add("Test3");
		
		System.out.println(arrayList.size());
		
	}
}
