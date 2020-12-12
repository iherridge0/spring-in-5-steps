package za.co.ieh.spring.basics.springin5steps;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import za.co.ieh.spring.basics.springin5steps.cdi.SomeCDIBusiness;
import za.co.ieh.spring.basics.springin5steps.cdi.SomeCDIDAO;

@RunWith(MockitoJUnitRunner.class)
public class SomeCDIBusinessTest {

	@InjectMocks
	SomeCDIBusiness someCDIBusiness;
	
	@Mock
	SomeCDIDAO daoMock;
	
	@Test
	public void testBasicScenario() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] {4,23,456,34,23235,34,2,897});
		assertEquals(23235, someCDIBusiness.findGreatest());
	}
	
	@Test
	public void testBasicScenario2() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, someCDIBusiness.findGreatest());
	}
	
	@Test
	public void testBasicScenario3() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] {1});
		assertEquals(1, someCDIBusiness.findGreatest());
	}

}
