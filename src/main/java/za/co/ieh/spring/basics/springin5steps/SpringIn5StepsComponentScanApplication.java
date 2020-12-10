package za.co.ieh.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import za.co.ieh.spring.basics.basic.BubbleSortAlgorithm;
import za.co.ieh.spring.basics.basic.SortAlgorithm;
import za.co.ieh.spring.basics.componentscan.ComponentDAO;

@Configuration
@ComponentScan("za.co.ieh.spring.basics.springin5steps")
@ComponentScan("za.co.ieh.spring.basics.basic")
public class SpringIn5StepsComponentScanApplication {

	static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsComponentScanApplication.class);

	public static void main(String[] args) {

		try(ConfigurableApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(SpringIn5StepsComponentScanApplication.class)){
			ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);
			
			LOGGER.info("{}", componentDAO);
			
			int[] numbers = {95,1,54,0,698,45,255,18948,151,48,356,18,2,9,4,58,6,14,5,56,4,9,9,5,5,56,5,691,19,9,126,6+45,65};
			
			SortAlgorithm sortAlgorithm = applicationContext.getBean(BubbleSortAlgorithm.class);
			
			sortAlgorithm.sort(numbers);
			
			for (int i = 0; i < numbers.length; i++) {
				LOGGER.info(String.valueOf(numbers[i]));
			}
		}
		
	}

}

/**
 * the ComponentDAO has been defined outside of the component scan (this
 * package), need to define where to
 * look @ComponentScan("za.co.ieh.spring.basics.componentscan")
 *
 * OUTPUT: Exception in thread "main"
 * 
 * 
 * org.springframework.beans.factory.NoSuchBeanDefinitionException: No
 * qualifying bean of type 'za.co.ieh.spring.basics.componentscan.ComponentDAO'
 * available at
 * org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(
 * DefaultListableBeanFactory.java:351) at
 * org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(
 * DefaultListableBeanFactory.java:342) at
 * org.springframework.context.support.AbstractApplicationContext.getBean(
 * AbstractApplicationContext.java:1177) at
 * za.co.ieh.spring.basics.springin5steps.SpringIn5StepsComponentScanApplication
 * .main(SpringIn5StepsComponentScanApplication.java:19)
 */