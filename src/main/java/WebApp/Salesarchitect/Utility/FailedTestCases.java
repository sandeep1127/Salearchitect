package WebApp.Salesarchitect.Utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.util.RetryAnalyzerCount;

public class FailedTestCases implements IAnnotationTransformer {        // This interface has method which will re-run the failed test cases 

	
	
	public void transform(ITestAnnotation annotation, Class testClass , Constructor testConstructor , Method testMethod ){
		
		
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		
		
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}