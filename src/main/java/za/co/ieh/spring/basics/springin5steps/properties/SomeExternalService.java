package za.co.ieh.spring.basics.springin5steps.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SomeExternalService {

	@Value("${external.service.url}") //pics up value from app.properties file
	private String url;
	
	public String returnServiceURL() {
		return url;
	}
}
