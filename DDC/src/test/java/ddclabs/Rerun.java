package ddclabs;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Rerun implements IRetryAnalyzer {
	    private int retryCount =0;
	    private int maxRetryCount = 2;

	    public boolean retry(ITestResult result) {

	        if (retryCount < maxRetryCount) {
	            retryCount++;
	            return true;
	        }
	        return false;
	    }

	}

