package za.co.ieh.spring.basics.springin5steps;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import za.co.ieh.spring.basics.basic.BinarySearchImpl;

//Load the context
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=SpringIn5StepsBasicApplication.class)
public class BasicSearchImplTest {

	//Get this bean from the context
	@Autowired
	BinarySearchImpl binarySearch;
	
	@Test
	public void testBasicScenario() {
		
		int actualResult = binarySearch.binarySearch(new int[] {}, 5);
		assertEquals(0, actualResult);
	}
	

}
