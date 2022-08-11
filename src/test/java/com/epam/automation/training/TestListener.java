package com.epam.automation.training;

import com.epam.automation.training.annotations.CustomAnnotations.APITests;
import com.epam.automation.training.annotations.CustomAnnotations.UITests;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestListener implements ITestListener {

    Method[] tests;

    public void onTestStart(ITestResult result) {
        tests = result.getTestClass().getRealClass().getMethods();
    }

    public void onTestSuccess(ITestResult result) {
    }

    public void onTestFailure(ITestResult result) {
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
        getUiTestsInfo();
    }

    private void getUiTestsInfo() {
        int counter = 0;
        String className = null;

        for (Method test : tests) {
            if (test.isAnnotationPresent(UITests.class)) {
                System.out.println(
                        "UI Test Class: " + test.getDeclaringClass() + "\n" +
                                "UI Test Method name: " + test.getName() + "\n" +
                                "UI Test Annotations: " + Arrays.toString(test.getDeclaredAnnotations())
                );
                counter++;
                className = test.getDeclaringClass().toString();
            } else if (test.isAnnotationPresent(APITests.class)) {
                System.out.println(test.getName() + " is not related to UI");
                className = test.getDeclaringClass().toString();
            }
        }
        System.out.println("The number of UI tests in the " + className + " is equal to " + counter);
    }
}
