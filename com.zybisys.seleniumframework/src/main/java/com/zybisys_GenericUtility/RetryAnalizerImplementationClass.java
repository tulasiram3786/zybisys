package com.zybisys_GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalizerImplementationClass implements IRetryAnalyzer {

	int count = 0;
	int retryCount = 5;

	public boolean retry(ITestResult result) {
		if (count < retryCount) {
			count++;
			return true;
		}
		return false;
	}
}
