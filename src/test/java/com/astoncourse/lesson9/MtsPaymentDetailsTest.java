package com.astoncourse.lesson9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class MtsPaymentDetailsTest {

    private WebDriver driver;
    private MtsHomePage mtsHomePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mtsHomePage = new MtsHomePage(driver);
        mtsHomePage.navigateTo("https://www.mts.by/");
        mtsHomePage.acceptCookiesIfPresent();
    }

    @Test(description = "Проверка плейсхолдеров на всех вкладках оплаты")
    public void testPlaceholdersOnAllTabs() {
        // 1. Услуги связи
        Assert.assertEquals(mtsHomePage.getPhoneInputPlaceholder(), "Номер телефона");

        // 2. Домашний интернет
        mtsHomePage.clickHomeInternetTab();
        Assert.assertEquals(mtsHomePage.getHomeInternetPlaceholder(), "Номер абонента");

        // 3. Рассрочка
        mtsHomePage.clickInstallmentTab();
        Assert.assertEquals(mtsHomePage.getInstallmentPlaceholder(), "Номер абонента");

        // 4. Задолженность
        mtsHomePage.clickDebtTab();
        // ФИНАЛЬНОЕ ИСПРАВЛЕНИЕ: Здесь тоже должен быть "Номер абонента"
        Assert.assertEquals(mtsHomePage.getDebtPlaceholder(), "Номер абонента");
    }

    @Test(description = "Проверка появления окна оплаты")
    public void testPaymentIframeAppears() {
        mtsHomePage.fillPhoneNumber("297777777");
        mtsHomePage.fillAmount("10");
        mtsHomePage.clickContinueButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement iframeElement = mtsHomePage.getPaymentIframe();
        wait.until(ExpectedConditions.visibilityOf(iframeElement));

        Assert.assertTrue(iframeElement.isDisplayed(), "Окно для оплаты (iframe) не появилось.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}