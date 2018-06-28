package spring.junit.mockito.test.Mockitosample.business;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BusinessTest {

	BusinessImpl businessImpl;
	@Before
	public void setUp() throws Exception {
		businessImpl = new BusinessImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_sum() {
		int expectedResult = businessImpl.calculateSum(new int[] {1,2,3});
		assertEquals(6, expectedResult);
	}
	@Test
	public void test_emptysum() {
		int expectedResult = businessImpl.calculateSum(new int[] {});
		assertEquals(0, expectedResult);
	}
	@Test
	public void test_sum_singleElem() {
		int expectedResult = businessImpl.calculateSum(new int[] {5});
		assertEquals(5, expectedResult);
	}
}
