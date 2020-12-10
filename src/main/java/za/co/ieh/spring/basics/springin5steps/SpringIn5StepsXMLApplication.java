package za.co.ieh.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import za.co.ieh.spring.basics.springin5steps.xml.XmlPersonDAO;

@Configuration
@ComponentScan
public class SpringIn5StepsXMLApplication {
	
	static Logger log = LoggerFactory.getLogger(SpringIn5StepsXMLApplication.class);
	
	public static void main(String[] args) {

		try(ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml")) {
			
			log.info("Beans Loaded -> {}", (Object)applicationContext.getBeanDefinitionNames());
				
			XmlPersonDAO xmlPersonDAO = applicationContext.getBean(XmlPersonDAO.class);
			log.info("{} jdbc-{}", xmlPersonDAO, xmlPersonDAO.getXmlJdbcConnection());
			
		}
	}
		

}
