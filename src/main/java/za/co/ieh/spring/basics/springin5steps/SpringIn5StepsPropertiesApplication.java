package za.co.ieh.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import za.co.ieh.spring.basics.springin5steps.properties.SomeExternalService;

@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class SpringIn5StepsPropertiesApplication {
	
	static Logger log = LoggerFactory.getLogger(SpringIn5StepsPropertiesApplication.class);
	
	public static void main(String[] args) {

		try(ConfigurableApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(SpringIn5StepsPropertiesApplication.class)) {
			
			log.info("Beans Loaded -> {}", (Object)applicationContext.getBeanDefinitionNames());
				
			SomeExternalService someExternalService= applicationContext.getBean(SomeExternalService.class);
			log.info("{} ", someExternalService.returnServiceURL());
			
		}
	}
		

}
