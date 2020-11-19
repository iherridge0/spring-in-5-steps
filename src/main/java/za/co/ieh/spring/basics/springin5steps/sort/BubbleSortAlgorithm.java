package za.co.ieh.spring.basics.springin5steps.sort;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm{

	public int[] sort(int[] numbers) {
		displayData(numbers);
		// Logic for Bubble Sort
		// Outer Loop - Controls the number of (successively small) passes through the array
		for (int i = 1; i < numbers.length-1; i++) {
			//Inner Loop - Controls the pairs of adjacent entries being compared
			for (int j = 0; j < numbers.length - i; j++) {
				if(numbers[j] > numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
			displayData(numbers);
		}
		
		return numbers;
	}
	
	public void displayData(int[] numbers) {
		System.out.println("----------");
		for (int x = 0; x < numbers.length; x++) {
			System.out.println(numbers[x]);
		}
	}
	
}
