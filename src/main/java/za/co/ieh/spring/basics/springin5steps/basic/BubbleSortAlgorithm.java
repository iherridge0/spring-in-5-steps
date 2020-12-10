package za.co.ieh.spring.basics.springin5steps.basic;

import org.springframework.stereotype.Component;

@Component
public class BubbleSortAlgorithm implements SortAlgorithm{

	// Logic for Bubble Sort
	public int[] sort(int[] numbers) {
		
		// Outer Loop - Controls the number of (successively small) passes through the array
		for (int i = 1; i < numbers.length-1; i++) {
			//displayData(numbers);
			
			//Inner Loop - Controls the pairs of adjacent entries being compared
			for (int j = 0; j < numbers.length - i; j++) {
				if(numbers[j] > numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		
		return numbers;
	}
	
	//Displays the list of numbers for debugging purposes
	public void displayData(int[] numbers) {
		System.out.println("----------");
		for (int x = 0; x < numbers.length; x++) {
			System.out.println(numbers[x]);
		}
	}
	
}
