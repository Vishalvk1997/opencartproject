

	package utilities;

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.*;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class Extentreportmanager implements ITestListener {

	    ExtentSparkReporter sparkReporter;
	    ExtentReports extent;
	    ExtentTest test;

	   
	    public void onStart(ITestContext context)
	    {
	        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreport.html");
	        sparkReporter.config().setDocumentTitle("Automation Test Report");
	        sparkReporter.config().setReportName("Functional Testing");

	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);

	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("Tester", "Vishal");
	    }

	    
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	    }

	   
	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
	    }

	    
	    public void onTestFailure(ITestResult result) {
	        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
	        test.log(Status.FAIL, "Reason: " + result.getThrowable());
	    }

	    
	    public void onTestSkipped(ITestResult result) {
	        test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
	    }

	   
	    public void onFinish(ITestContext context) {
	        extent.flush(); // Writes everything to the report
	    }
	}



