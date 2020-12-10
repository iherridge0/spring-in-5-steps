package za.co.ieh.spring.basics.basic;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Inject //or @Autowired 
	//@Qualifier("radix")
	private SortAlgorithm sortAlgorithm;

	public int binarySearch(int[] numbers, int numberToSearchFor) {
		// Implementing Sorting Logic
		//viewArray(numbers);
		sortAlgorithm.sort(numbers);
		//viewArray(numbers);
		
		//Search the array
		
		//Return the result
		return 0;
	}
	
	public void viewArray(int[] numbers) {
		System.out.println();
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
	}
	
	/*
	 * @PostConstruct public void postConstruct() { log.info("{}", sortAlgorithm); }
	 * 
	 * @PreDestroy public void preDestroy() { log.info("{}", sortAlgorithm); }
	 */
}
