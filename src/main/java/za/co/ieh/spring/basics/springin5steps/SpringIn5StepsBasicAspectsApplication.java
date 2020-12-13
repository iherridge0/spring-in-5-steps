package za.co.ieh.spring.basics.springin5steps;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import za.co.ieh.spring.basics.basic.BinarySearchImpl;
import za.co.ieh.spring.basics.basic.BubbleSortAlgorithm;
import za.co.ieh.spring.basics.basic.QuickSortAlgorithm;
import za.co.ieh.spring.basics.basic.RadixBucketSort;

@SpringBootApplication
@ComponentScan("za.co.ieh.spring.basics")
public class SpringIn5StepsBasicAspectsApplication {

	public static void main(String[] args) {

		try (ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringIn5StepsBasicApplication.class)) {
			
			int[] numbers = new int[] { 12, 4, 6, 45, 3, 65, 33, 47, 2, 43, 5,34,346,234,226,3456,5,23,2,2,6,36,345657,23,124,36,6,126,2,25,123,512,56,247,246,2345,234,24,2356,356,356,6,6,7,2,71,761,12,52,2,342,353,635,623,4123,36,34,5234,246,457,37,56,23456,0};
			
			BubbleSortAlgorithm bubbleSortAlgorithm = applicationContext.getBean(BubbleSortAlgorithm.class);
			bubbleSortAlgorithm.sort(numbers);
			
			numbers = new int[] { 12, 4, 6, 45, 3, 65, 33, 47, 2, 43, 5,34,346,234,226,3456,5,23,2,2,6,36,345657,23,124,36,6,126,2,25,123,512,56,247,246,2345,234,24,2356,356,356,6,6,7,2,71,761,12,52,2,342,353,635,623,4123,36,34,5234,246,457,37,56,23456,0};
			
			QuickSortAlgorithm quickSortAlgorithm = applicationContext.getBean(QuickSortAlgorithm.class);
			quickSortAlgorithm.sort(numbers);
			
			numbers = new int[] { 12, 4, 6, 45, 3, 65, 33, 47, 2, 43, 5,34,346,234,226,3456,5,23,2,2,6,36,345657,23,124,36,6,126,2,25,123,512,56,247,246,2345,234,24,2356,356,356,6,6,7,2,71,761,12,52,2,342,353,635,623,4123,36,34,5234,246,457,37,56,23456,0};
			
			RadixBucketSort radixBucketSort = applicationContext.getBean(RadixBucketSort.class);
			radixBucketSort.sort(numbers);
		}

	}

}
