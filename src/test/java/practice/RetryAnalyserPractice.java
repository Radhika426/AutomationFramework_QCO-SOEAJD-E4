package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer = genericUtilities.RetryAnalyzerImplementation.class)
	public void analyser() {
		//Assert.fail();//java.lang.AssertionError: null
		System.out.println("hi");
		
	}

}
