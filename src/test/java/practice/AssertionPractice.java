package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void sample() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		//Assert.assertEquals(false, true);
		
		System.out.println("Step 3");
		System.out.println("Step 4");
		
	}
	
	@Test
	public void sample1() {
		//SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		//sa.assertTrue(false);
		
		System.out.println("Step 3");
		System.out.println("Step 4");
		
		//sa.assertAll();
		
	}

}
