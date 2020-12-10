package za.co.ieh.spring.basics.basic;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Radix sort, also known as Bucket Sort
 * 
 * @author irwin
 *
 */
@Service
@Primary
//@Qualifier("radix")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RadixBucketSort implements SortAlgorithm {
	
	@Override
	public int[] sort(int[] numbers) {
		// Logic for Radix/Bucket Sort
		int highestNumber = highestNumber(numbers);
		int zeros = calculateLeadingZeros(highestNumber);
		String[] numberStrings = addZeros(numbers, zeros);
		
		int numberOfSorts = zeros;
		int counter = 0;
		while(counter < numberOfSorts) {
			numberStrings = sort(numberStrings, counter);
			counter++;
		}

		for (int i = 0; i < numberStrings.length; i++) {
			numbers[i] = Integer.parseInt(numberStrings[i]);
		}

		return numbers;
	}

	private String[] sort(String[] numberStrings, int counter) {
		String[] sorted = new String[numberStrings.length];
		LinkedHashMap<Integer, ArrayList<String>> buckets = new LinkedHashMap<>();
		for (int i = 0; i < 10; i++) {
			ArrayList<String> bucket = new ArrayList<>();
			for (int j = 0; j < numberStrings.length; j++) {
				int validate = Integer.parseInt(numberStrings[j].substring(numberStrings[j].length()-counter-1, numberStrings[j].length()-counter));
				if(validate == i)
					bucket.add(numberStrings[j]);
			}
			buckets.put(i, bucket);
		}
		
		int stepper = 0;
		for (int i = 0; i < buckets.size(); i++) {
			ArrayList<String> bucket = buckets.get(i);
			for (int j = 0; j < bucket.size(); j++) {
				sorted[stepper] = bucket.get(j);
				stepper++;
			}
		}
		return sorted;
	}

	private int calculateLeadingZeros(int highestNumber) {
		int count = 1;
		int multiplier = 10;
		boolean exit = false;
		while(!exit) {
			if(Math.abs(highestNumber / multiplier) != 0) {
				multiplier = multiplier * 10;
				count++;
			} else
				break;
		}
		return count;
	}

	private int highestNumber(int[] numbers) {
		int max = 0;
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] > max)
				max = numbers[i];
		}
		return max;
	}

	private String[] addZeros(int[] numbers, int zeros) {
		// TODO Auto-generated method stub
		String[] zeroStrings = new String[numbers.length];
		for (int i = 0; i < zeroStrings.length; i++) {
			zeroStrings[i] = String.format("%0" + zeros + "d", numbers[i]);
		}
		return zeroStrings;
	}

}
