package spring.junit.mockito.test.Mockitosample.business;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spring.junit.mockito.test.Mockitosample.data.DataService;

class DataServiceStub implements DataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {1,2,3};
	}	
}
class DataServiceEmptyStub implements DataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {};
	}	
}

class DataServiceSingleElemStub implements DataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {5};
	}	
}
public class BusinessStubTest {

	BusinessImpl businessImpl;
	@Before
	public void setUp() throws Exception {
		businessImpl = new BusinessImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_sum_basic_usingStub() {
		businessImpl.setDataService(new DataServiceStub());
		int expectedResult = businessImpl.calculateSumUsingDataService();
		assertEquals(6, expectedResult);
	}
	@Test
	public void test_emptysum_usingStub() {
		businessImpl.setDataService(new DataServiceEmptyStub());
		int expectedResult = businessImpl.calculateSumUsingDataService();
		assertEquals(0, expectedResult);
	}
	@Test
	public void test_sum_singleElem_usingStub() {
		businessImpl.setDataService(new DataServiceSingleElemStub());
		int expectedResult = businessImpl.calculateSumUsingDataService();
		assertEquals(5, expectedResult);
	}
}
