package com.astoncourse.lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsHomePage extends BasePage {

    // --- Локаторы ---

    @FindBy(id = "cookie-agree")
    private WebElement acceptCookiesButton;

    // ИСПОЛЬЗУЕМ ТОЧКУ ВМЕСТО TEXT() для учета вложенных тегов
    @FindBy(xpath = "//h2[.='Онлайн пополнение без комиссии']")
    private WebElement paymentBlockTitle;

    private final By paymentLogosLocator = By.cssSelector("div.pay__partners img");

    @FindBy(linkText = "Подробнее о сервисе")
    private WebElement moreAboutServiceLink;

    @FindBy(id = "connection-phone")
    private WebElement phoneInput;

    @FindBy(id = "connection-sum")
    private WebElement amountInput;

    @FindBy(xpath = "//form[@id='pay-connection']//button[@type='submit']")
    private WebElement submitButton;

    // Исправляем опечатку с '///' на '//'
    @FindBy(xpath = "//iframe[contains(@class, 'bepaid-iframe')]")
    private WebElement paymentIframe;

    public MtsHomePage(WebDriver driver) {
        super(driver);
    }

    // --- Методы ---

    public void acceptCookiesIfPresent() {
        try {
            WebDriverWait cookieWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            cookieWait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton)).click();
            System.out.println("Cookie баннер найден и закрыт.");
        } catch (TimeoutException e) {
            System.out.println("Cookie баннер не был найден, продолжаю выполнение теста.");
        }
    }

    public String getPaymentBlockTitleText() {
        wait.until(ExpectedConditions.visibilityOf(paymentBlockTitle));
        return paymentBlockTitle.getText();
    }

    public List<WebElement> getPaymentLogos() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(paymentLogosLocator));
        return driver.findElements(paymentLogosLocator);
    }

    public void clickMoreAboutServiceLink() {
        moreAboutServiceLink.click();
    }

    public void fillPhoneNumber(String phoneNumber) {
        phoneInput.sendKeys(phoneNumber);
    }

    public void fillAmount(String amount) {
        amountInput.sendKeys(amount);
    }

    public void clickContinueButton() {
        submitButton.click();
    }

    public boolean isPaymentIframeDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(paymentIframe)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void navigateTo(String url) {
        driver.get(url);
    }
}