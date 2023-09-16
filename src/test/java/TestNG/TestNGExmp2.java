package TestNG;

import org.aopalliance.intercept.Invocation;
import org.testng.annotations.Test;

public class TestNGExmp2 {
	@Test(invocationCount = 2,priority = 1)
	public void CreateContact()
	
	{
		System.out.println("Contact Created");
	}
	@Test(priority =0 )
	public void ContactNotCreated()
	
	{
		System.out.println("Contact Not Created");
	}
	
   
}
