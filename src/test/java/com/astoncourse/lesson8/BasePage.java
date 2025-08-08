package com.astoncourse.lesson8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Базовый класс для всех страниц.
 * Хранит в себе экземпляр драйвера и ожидания.
 * Инициализирует элементы страниц.
 */
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // PageFactory нужен для инициализации элементов, найденных по аннотации @FindBy
        PageFactory.initElements(driver, this);
    }
}