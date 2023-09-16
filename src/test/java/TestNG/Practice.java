package TestNG;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

public class Practice {
	@Test
	public void AssertTest() 
	{
		System.out.println("test NG");
		Assert.assertEquals("A", "B");
		System.out.println("After Assert execution");
		
	}
	
	@Test
	public void SoftAssert()
	{
       SoftAssert sa = new SoftAssert();	
       System.out.println("Step1");
       sa.assertEquals(1, 2);
       System.out.println("Step2");
       System.out.println("Step3");
       sa.assertAll();
	}
	

}
