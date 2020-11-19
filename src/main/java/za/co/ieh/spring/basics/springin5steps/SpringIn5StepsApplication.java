package za.co.ieh.spring.basics.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import za.co.ieh.spring.basics.springin5steps.search.BinarySearchImpl;

@SpringBootApplication
public class SpringIn5StepsApplication {
	
	// What are the beans - Annotated with @Component
	// What are the dependencies of the bean? -  Annotated with @Autowiring
	// Where to search for beans? => No need, as all will be searched within this applications package - package za.co.ieh.spring.basics.springin5steps;

	public static void main(String[] args) {

		//Implemented dummy methods for binary search
		//BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());
		
		//Application Context
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsApplication.class, args);
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearch.binarySearch(new int[] {12, 4, 6, 45, 3, 65, 33, 47, 2, 43, 5}, 3);
		System.out.println(result);
	}

}
