package com.astoncourse.lesson10;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Attachment(value = "Скриншот в момент ошибки", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = MtsPaymentDetailsTest.driver;
        if (driver != null) {
            System.out.println("Делаю скриншот для упавшего теста...");
            saveScreenshotPNG(driver);
        }
    }
}