package TestNG;

import org.testng.annotations.Test;

public class TestNGEx3 {

@Test
public void CreateContact()
	
	{
	    int arr[]= {1,2,3};
	    System.out.println(arr[5]);
		System.out.println("Contact Created");
	}
	@Test(dependsOnMethods ="CreateContact")
	public void ContactNotCreated()
	
	{
		System.out.println("Contact Not Created");
	}

}
