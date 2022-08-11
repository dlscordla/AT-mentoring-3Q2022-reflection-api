package com.epam.automation.training;

import com.epam.automation.training.annotations.CustomAnnotations.UITests;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestListener implements ITestListener {

    int counter = 0;

    public void onTestStart(ITestResult result) {

        Method[] tests = result.getTestClass().getRealClass().getDeclaredMethods();
        for (Method test : tests) {
            if (test.isAnnotationPresent(UITests.class)) {
                counter++;
                System.out.println(
                        "UI Test Method name: " + test.getName() + "\n" +
                                "UI Test Class: " + test.getDeclaringClass() + "\n" +
                                "UI Test Annotations: " + Arrays.toString(test.getDeclaredAnnotations())
                );
            }
        }
        System.out.println("The number of UI tests: " + counter);
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
    }
}
