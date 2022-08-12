package com.epam.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class UiPlaygroundClickPage {

    private static final String URL = "http://uitestingplayground.com/click";

    WebDriver webDriver;

    public UiPlaygroundClickPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//button[@id='badButton']")
    private WebElement button;

    public UiPlaygroundClickPage openPage() {
        webDriver.get(URL);
        return this;
    }

    public UiPlaygroundClickPage clickButton() {
        new Actions(webDriver).click(button).pause(Duration.ofSeconds(3)).moveToElement(button).build().perform();
        return this;
    }

    public String getButtonColor() {
        return button.getCssValue("background-color");
    }
}
