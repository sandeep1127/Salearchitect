package WebApp.Salesarchitect.Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{          

			
int counter = 0;               
int retryLimit = 3;   // here we have the logic to re- run the failed cases 3 times.  ( FYI : we created  FailedTestCases class for implementing of re-running the Failed test cases where we used "IAnnotationTransformer" Interface)>( From Naveen Automation)

public boolean retry(ITestResult result){
	
	if(counter<retryLimit){
		
counter++;
return true;
	}
	return false;
}
	
	
	
	
	
	
}
