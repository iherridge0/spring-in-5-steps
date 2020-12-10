package za.co.ieh.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import za.co.ieh.spring.basics.springin5steps.scope.PersonDAO;

@Configuration
@ComponentScan("za.co.ieh.spring.basics.springin5steps")
@ComponentScan("za.co.ieh.spring.basics.basic")
public class SpringIn5StepsScopeApplication {
	
	static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsScopeApplication.class);
	
	public static void main(String[] args) {

		try(ConfigurableApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(SpringIn5StepsScopeApplication.class)){
			PersonDAO personDao1 = applicationContext.getBean(PersonDAO.class);
			
			PersonDAO personDao2 = applicationContext.getBean(PersonDAO.class);
			
			LOGGER.info("{}", personDao1);
			LOGGER.info("{}", personDao2);
			
			LOGGER.info("{}", personDao1.getJdbcConnection());
			LOGGER.info("{}", personDao2.getJdbcConnection());
			applicationContext.close();
		}
		
	}

}
