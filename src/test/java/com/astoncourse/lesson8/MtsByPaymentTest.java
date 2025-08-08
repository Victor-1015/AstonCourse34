package com.astoncourse.lesson8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class MtsByPaymentTest {

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

    // ИЗМЕНЕНИЕ ЗДЕСЬ
    @Test(description = "Проверка названия блока оплаты")
    public void testBlockTitle() {
        // 1. Получаем "сырой" текст со страницы
        String rawTitle = mtsHomePage.getPaymentBlockTitleText();

        // 2. Заменяем возможный перенос строки на пробел
        String normalizedTitle = rawTitle.replace("\n", " ");

        // 3. Проверяем уже нормализованный текст
        Assert.assertTrue(normalizedTitle.contains("Онлайн пополнение без комиссии"), "Заголовок блока неверный.");
    }

    @Test(description = "Проверка наличия логотипов")
    public void testPaymentLogosPresence() {
        List<WebElement> logos = mtsHomePage.getPaymentLogos();
        Assert.assertFalse(logos.isEmpty(), "Логотипы платежных систем не найдены.");
        Assert.assertTrue(logos.size() > 1, "Найдено меньше двух логотипов.");
    }

    @Test(description = "Проверка ссылки 'Подробнее о сервисе'")
    public void testMoreAboutServiceLink() {
        mtsHomePage.clickMoreAboutServiceLink();

        String currentUrl = driver.getCurrentUrl();
        String expectedUrlPart = "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        Assert.assertTrue(currentUrl.contains(expectedUrlPart), "URL страницы не соответствует ожидаемому.");
    }

    @Test(description = "Проверка формы оплаты услуг связи")
    public void testPaymentForm() {
        mtsHomePage.fillPhoneNumber("297777777");
        mtsHomePage.fillAmount("10");
        mtsHomePage.clickContinueButton();

        Assert.assertTrue(mtsHomePage.isPaymentIframeDisplayed(), "Iframe для оплаты не загрузился.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}