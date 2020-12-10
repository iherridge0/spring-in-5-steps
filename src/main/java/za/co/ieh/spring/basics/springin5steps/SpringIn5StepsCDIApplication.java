package za.co.ieh.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import za.co.ieh.spring.basics.springin5steps.cdi.SomeCDIBusiness;

@SpringBootApplication
public class SpringIn5StepsCDIApplication {
	
	static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsCDIApplication.class);
	
	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsCDIApplication.class, args);
		SomeCDIBusiness someCDIBusiness = applicationContext.getBean(SomeCDIBusiness.class);
		SomeCDIBusiness someCDIBusiness2 = applicationContext.getBean(SomeCDIBusiness.class);
		LOGGER.info("{} dao-{} dao2-{}", someCDIBusiness, someCDIBusiness.getSomeCDIDAO(), someCDIBusiness2.getSomeCDIDAO());
	}

}
