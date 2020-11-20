package com.shoppingsite.qa.ExtentReport;

import com.relevantcodes.extentreports.ExtentReports;
import com.shoppingsite.qa.base.TestBase;

/**
ExtentReports instance is created by calling getReporter() method from ExtentManager.
**/
public class ExtentManager extends TestBase {
	 private static ExtentReports extent;
	  public String workingDir = prop.getProperty("workingDir");
	    public synchronized static ExtentReports getReporter() {
	        if (extent == null) {
	            //Set HTML reporting file location
	            String workingDir = System.getProperty("user.dir");
	            if (System.getProperty("os.name").toLowerCase().contains("win")) {
	                extent = new ExtentReports(workingDir + "\\ExtentReports\\ExtentReportResults.html", true);
	            }
	          
	        }
	        return extent;
	    }
}
