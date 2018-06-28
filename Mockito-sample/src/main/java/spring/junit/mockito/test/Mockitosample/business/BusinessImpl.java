package spring.junit.mockito.test.Mockitosample.business;

import spring.junit.mockito.test.Mockitosample.data.DataService;

public class BusinessImpl {

	DataService dataService;
	

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	public int calculateSum(int[] data) {
		int sum = 0;
		for(int elem : data) {
			sum += elem;
		}
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = dataService.retrieveAllData();
		for(int elem : data) {
			sum += elem;
		}
		return sum;
	}
}
