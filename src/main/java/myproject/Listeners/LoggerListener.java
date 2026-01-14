package myproject.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LoggerListener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite" + context.getCurrentXmlTest().getName() + "Started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite '" + context.getName() + "' finished.");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test '" + result.getName() + "' started.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test '" + result.getName() + "' PASSED.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test '" + result.getName() + "' FAILED. Exception: " + result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test '" + result.getName() + "' SKIPPED.");
    }
}
