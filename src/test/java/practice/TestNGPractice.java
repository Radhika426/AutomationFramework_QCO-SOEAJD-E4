package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void createCustomer() {
		//Assert.fail();//used to forcefully fail the script
		System.out.println("Create");
	}
	
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer() {
		System.out.println("modify");
	}
    
	@Test
	public void deleteCustomer() {
		System.out.println("delete");
	}
	
	//enabled is used for analysis, its like that particular script is commented.


}
