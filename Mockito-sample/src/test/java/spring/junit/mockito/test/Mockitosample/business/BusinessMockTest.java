package spring.junit.mockito.test.Mockitosample.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import spring.junit.mockito.test.Mockitosample.data.DataService;

@RunWith(MockitoJUnitRunner.class)
public class BusinessMockTest {

	@InjectMocks
	BusinessImpl businessImpl = new BusinessImpl();
	@Mock
	DataService dataServiceMock;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_sum_basic_usingMock() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
		int expectedResult = businessImpl.calculateSumUsingDataService();
		assertEquals(6, expectedResult);
	}
	@Test
	public void test_emptysum_usingStub() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		int expectedResult = businessImpl.calculateSumUsingDataService();
		assertEquals(0, expectedResult);
	}
	@Test
	public void test_sum_singleElem_usingStub() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
		int expectedResult = businessImpl.calculateSumUsingDataService();
		assertEquals(5, expectedResult);
	}
}
