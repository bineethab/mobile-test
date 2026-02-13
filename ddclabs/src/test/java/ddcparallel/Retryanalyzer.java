package ddcparallel;

import org.testng.ITestResult;
import org.testng.IRetryAnalyzer;


	public class Retryanalyzer implements IRetryAnalyzer {
	    private int retryCount = 0;
	    private static final int MAX_RETRY_COUNT = 1; 

	    @Override
	    public boolean retry(ITestResult result) {
	        if (retryCount < MAX_RETRY_COUNT) {
	            retryCount++;
	            return true; 
	        }
	        return false; // Do not retry further
	    }
	}


