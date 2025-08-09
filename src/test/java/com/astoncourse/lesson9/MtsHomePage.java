package com.astoncourse.lesson9;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MtsHomePage extends BasePage {

    @FindBy(id = "cookie-agree") private WebElement acceptCookiesButton;
    @FindBy(xpath = "//h2[.='Онлайн пополнение без комиссии']") private WebElement paymentBlockTitle;
    private final By paymentLogosLocator = By.cssSelector("div.pay__partners img");
    @FindBy(linkText = "Подробнее о сервисе") private WebElement moreAboutServiceLink;
    @FindBy(id = "connection-phone") private WebElement phoneInput;
    @FindBy(id = "connection-sum") private WebElement amountInput;
    @FindBy(xpath = "//form[@id='pay-connection']//button[@type='submit']") private WebElement submitButton;
    @FindBy(xpath = "//iframe[contains(@class, 'bepaid-iframe')]") private WebElement paymentIframe;
    @FindBy(className = "select__header") private WebElement serviceDropdown;
    @FindBy(xpath = "//p[text()='Домашний интернет']") private WebElement homeInternetTab;
    @FindBy(xpath = "//p[text()='Рассрочка']") private WebElement installmentTab;
    @FindBy(xpath = "//p[text()='Задолженность']") private WebElement debtTab;
    @FindBy(id = "internet-phone") private WebElement universalAccountInput;

    public MtsHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    private void clickViaJs(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickHomeInternetTab() {
        clickViaJs(serviceDropdown);
        clickViaJs(wait.until(ExpectedConditions.visibilityOf(homeInternetTab)));
    }

    public void clickInstallmentTab() {
        clickViaJs(serviceDropdown);
        clickViaJs(wait.until(ExpectedConditions.visibilityOf(installmentTab)));
    }

    public void clickDebtTab() {
        clickViaJs(serviceDropdown);
        clickViaJs(wait.until(ExpectedConditions.visibilityOf(debtTab)));
    }

    public void acceptCookiesIfPresent() {
        try {
            WebDriverWait cookieWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            cookieWait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton)).click();
        } catch (TimeoutException e) {
            System.out.println("Cookie баннер не был найден.");
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
    public WebElement getPaymentIframe() {
        return paymentIframe;
    }
    public void navigateTo(String url) {
        driver.get(url);
    }
    public String getHomeInternetPlaceholder() {
        wait.until(ExpectedConditions.visibilityOf(universalAccountInput));
        return universalAccountInput.getAttribute("placeholder");
    }
    public String getInstallmentPlaceholder() {
        wait.until(ExpectedConditions.visibilityOf(universalAccountInput));
        return universalAccountInput.getAttribute("placeholder");
    }
    public String getDebtPlaceholder() {
        wait.until(ExpectedConditions.visibilityOf(universalAccountInput));
        return universalAccountInput.getAttribute("placeholder");
    }
    public String getPhoneInputPlaceholder() {
        return phoneInput.getAttribute("placeholder");
    }
}
