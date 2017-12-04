package PlatformListerner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import PlatformHelper.HelperClass;

public class TestNGListerner implements ITestListener
{

	@Override
	public void onFinish(ITestContext result) 
	{
		System.out.println("TestCase on Finish and details are " + result.getName());
		
	}

	@Override
	public void onStart(ITestContext result) 
	{
		System.out.println("TestCase on Start and details are " + result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		System.out.println("TestCase on Test Failed But With in Success Percentage and details are " + result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("TestCase failed and details are " + result.getName());
		if(ITestResult.FAILURE==result.getStatus())
		{
			HelperClass.captureScreenshot( result.getName());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("TestCase skipped and details are " + result.getName());
		
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println("TestCase on Start and details are " + result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("TestCase Passed and details are " + result.getName());
		
	}

}
