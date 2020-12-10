package za.co.ieh.spring.basics.springin5steps;

import java.awt.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import za.co.ieh.spring.basics.basic.BinarySearchImpl;

@Configuration
@ComponentScan("za.co.ieh.spring.basics.springin5steps")
@ComponentScan("za.co.ieh.spring.basics.basic")
public class SpringIn5StepsBasicApplication {
	
	// What are the beans - Annotated with @Component
	// What are the dependencies of the bean? -  Annotated with @Autowiring
	// Where to search for beans? => No need, as all will be searched within this applications package - package za.co.ieh.spring.basics.springin5steps;

	public static void main(String[] args) {

		//Implemented dummy methods for binary search
		//BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());
		
		//Application Context
		try(ConfigurableApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(SpringIn5StepsBasicApplication.class)) {
			/**
			 * Default - Singleton - One instance per Spring Context
			 */
				BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
				BinarySearchImpl binarySearch1 = applicationContext.getBean(BinarySearchImpl.class);
				System.out.println(binarySearch);
				System.out.println(binarySearch1);
				
				
			/**
			 * Output: as can seen it is a single bean, same reference - singleton
			 * za.co.ieh.spring.basics.springin5steps.search.BinarySearchImpl@88d6f9b
			 * za.co.ieh.spring.basics.springin5steps.search.BinarySearchImpl@88d6f9b
			 */
				
				/**
				 * 
				 * @Component
				 * @Scope("prototype")
				 * public class BinarySearchImpl {
				 * 
				 * OR
				 * 
				 * @Component
				 * @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
				 * public class BinarySearchImpl {
				 * 
				 * Output: as can seen a new instance is created for each bean - prototype
				 * za.co.ieh.spring.basics.springin5steps.search.BinarySearchImpl@58783f6c
				 * za.co.ieh.spring.basics.springin5steps.search.BinarySearchImpl@3a7b503d	
				 *
				 */
				
				
			binarySearch.binarySearch(new int[] {12, 4, 6, 45, 3, 65, 33, 47, 2, 43, 5}, 3);
			binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		}
		
		
		
	}
		

}
