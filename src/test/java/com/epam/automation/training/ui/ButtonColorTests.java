package com.epam.automation.training.ui;

import com.epam.automation.training.TestSetup;
import com.epam.automation.training.annotations.CustomAnnotations.UITests;
import com.epam.automation.training.pages.UiPlaygroundClickPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ButtonColorTests extends TestSetup {

    WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    @UITests(description = "Verify that the button color is green")
    public void verifyButtonIsGreen() {
        String buttonColor = new UiPlaygroundClickPage(webDriver)
                .openPage()
                .clickButton()
                .getButtonColor();
        assertEquals(Color.fromString(buttonColor).asHex(), "#218838");
    }
}
