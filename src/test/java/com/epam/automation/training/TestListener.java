package com.epam.automation.training;

import com.epam.automation.training.annotations.CustomAnnotations.UITests;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult result) {
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
        int counter = 0;
        ITestNGMethod[] testNGMethods = context.getAllTestMethods();

        for (ITestNGMethod testNGMethod : testNGMethods) {
            Method test = testNGMethod.getConstructorOrMethod().getMethod();
            if (test.isAnnotationPresent(UITests.class)) {
                System.out.println(
                        test.getDeclaringClass() + "\n" +
                                "UI Test Method name: " + test.getName() + "\n" +
                                "UI Test Annotations: " + Arrays.toString(test.getDeclaredAnnotations())
                );
                counter++;
            }
        }
        System.out.println("The number of UI tests in the Suite is equal to " + counter);
    }
}
