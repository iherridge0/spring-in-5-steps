package za.co.ieh.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import za.co.ieh.spring.basics.springin5steps.cdi.SomeCDIBusiness;

@Configuration
@ComponentScan("za.co.ieh.spring.basics.springin5steps")
public class SpringIn5StepsCDIApplication {
	
	static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsCDIApplication.class);
	
	public static void main(String[] args) {

		try(ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsCDIApplication.class)){
			SomeCDIBusiness someCDIBusiness = applicationContext.getBean(SomeCDIBusiness.class);
			SomeCDIBusiness someCDIBusiness2 = applicationContext.getBean(SomeCDIBusiness.class);
			LOGGER.info("{} dao-{} dao2-{}", someCDIBusiness, someCDIBusiness.getSomeCDIDAO(), someCDIBusiness2.getSomeCDIDAO());	
		};
		
	}

}
/*
 * SAME AS: only now using the auto Closeable interface
 * 
 * public static void main(String[] args) {
 * 
 * ConfigurableApplicationContext applicationContext = new
 * AnnotationConfigApplicationContext(SpringIn5StepsCDIApplication.class);
 * SomeCDIBusiness someCDIBusiness =
 * applicationContext.getBean(SomeCDIBusiness.class); SomeCDIBusiness
 * someCDIBusiness2 = applicationContext.getBean(SomeCDIBusiness.class);
 * LOGGER.info("{} dao-{} dao2-{}", someCDIBusiness,
 * someCDIBusiness.getSomeCDIDAO(), someCDIBusiness2.getSomeCDIDAO()); }
 */