package WebApp.Salesarchitect.Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{          

			
int counter = 0;               
int retryLimit = 3;   // here we have the logic to re- run the failed cases 3 times

public boolean retry(ITestResult result){
	
	if(counter<retryLimit){
		
counter++;
return true;
	}
	return false;
}
	
	
	
	
	
	
}
