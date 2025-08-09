package com.astoncourse.lesson10;

import com.astoncourse.lesson10.AllureListener;
import com.astoncourse.lesson10.MtsHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;

@Epic("MTS Web Portal Testing")
@Feature("Online Payment Functionality")
@Listeners({AllureListener.class})
public class MtsPaymentDetailsTest {

    public static WebDriver driver;
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
    @Description("Тест проверяет, что на всех вкладках блока оплаты ('Услуги связи', 'Домашний интернет' и т.д.) отображаются корректные плейсхолдеры в полях для ввода.")
    public void testPlaceholdersOnAllTabs() {
        Assert.assertEquals(mtsHomePage.getPhoneInputPlaceholder(), "Номер телефона");

        mtsHomePage.clickHomeInternetTab();
        Assert.assertEquals(mtsHomePage.getHomeInternetPlaceholder(), "Номер абонента");

        mtsHomePage.clickInstallmentTab();
        Assert.assertEquals(mtsHomePage.getInstallmentPlaceholder(), "Номер абонента");

        mtsHomePage.clickDebtTab();
        Assert.assertEquals(mtsHomePage.getDebtPlaceholder(), "Номер абонента");
    }

    @Test(description = "Проверка появления окна оплаты")
    @Description("Тест проверяет, что после заполнения формы 'Услуги связи' и нажатия кнопки 'Продолжить' появляется iframe для проведения платежа.")
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