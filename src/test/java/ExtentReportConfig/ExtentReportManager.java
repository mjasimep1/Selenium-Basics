package ExtentReportConfig;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Testing started..");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test is passed: "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test is failed: "+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

}
