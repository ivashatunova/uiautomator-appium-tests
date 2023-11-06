package ru.netology.qa;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.qa.screens.AutomatorPage;

public class UIAutomatorTest {

    private AndroidDriver driver;
    private String emptyString = " ";

    private AutomatorPage automatorPage;


    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Some name");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);


        URL remoteUrl = new URL("http://127.0.0.1:4723/");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

        automatorPage = new AutomatorPage(driver);
    }


    @Test
    public void sampleTest() {
        automatorPage.userInput.isDisplayed();
        automatorPage.userInput.click();
        automatorPage.userInput.sendKeys(emptyString);

        automatorPage.buttonChange.isDisplayed();
        automatorPage.buttonChange.click();

        automatorPage.userInput.isDisplayed();
        Assertions.assertEquals(emptyString,automatorPage.userInput.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
