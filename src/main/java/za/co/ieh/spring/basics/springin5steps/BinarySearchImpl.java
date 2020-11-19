package za.co.ieh.spring.basics.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	@Autowired
	private SortAlgorithm sortAlgorithm;
	
	// Bubble Sort Algorithm OR Quick Sort Algorithm OR any other sorting algorithm that is implemented.
	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}

	public int binarySearch(int[] numbers, int numberToSearchFor) {
	// Implementing Sorting Logic
		
		int[] sorted = sortAlgorithm.sort(numbers);
		System.out.println(sortAlgorithm.toString());

	//Search the array
		
	//Return the result
		return 0;
	}
}
