package za.co.ieh.spring.basics.basic;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class QuickSortAlgorithm implements SortAlgorithm {

	public int[] sort(int[] numbers) {
		
		// Logic for Quick Sort
		return sort(numbers, 0, numbers.length - 1);
	}
	
	private int[] sort(int[] numbers, int low, int high) {
		
		if(low < high + 1) {
			int p = partition(numbers, low, high);
			sort(numbers, low, p-1);
			sort(numbers, p+1, high);
		}
		return numbers;
	}

	private int partition(int[] numbers, int low, int high) {
		// TODO Auto-generated method stub
		swap(numbers, low, getPivot(low, high));
		int border = low + 1;
		for(int i = border; i <= high; i++) {
			if(numbers[i] < numbers[low]) {
				swap(numbers, i, border++);
			}
		}
		swap(numbers, low, border-1);
		return border-1;
	}

	private int getPivot(int low, int high) {
		Random rand = new Random();
		return rand.nextInt((high-low)+1) + low;
	}
	
	private void swap(int[] numbers, int index1, int index2) {
		int temp = numbers[index1];
		numbers[index1] = numbers[index2];
		numbers[index2] = temp;
	}
}
