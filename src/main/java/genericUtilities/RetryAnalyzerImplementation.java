package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation to IRetryAnalyser interface of TestNG
 * @author Radhika S
 *
 */
public class RetryAnalyzerImplementation implements IRetryAnalyzer {
    
	int count=0;
	int retryCount=3;
	
	public boolean retry(ITestResult result)//result is by default true
	{
		//0<3->T  1<3->T  2<3->T  3<3->F
		while(count<retryCount) 
		{
			count++;//1 2 3
			return true;//retry //retry //retry
		}
		return false;//Stop execution
	}
	
	

}
