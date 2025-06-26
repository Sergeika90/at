package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigProvider;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        // Добавляем Allure-листенер для Selenide
        System.out.println("Initializing AllureSelenide listener...");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .includeSelenideSteps(true)
        );

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        // Настройки Chrome в headless-режиме
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        Configuration.browserCapabilities = options;

        // URL Selenium Grid (работает и в Docker, и локально с localhost)
        Configuration.remote = ConfigProvider.getSeleniumGridUrl(); // или "http://selenium-hub:4444"

        // Отключаем закрытие браузера после каждого теста (для Selenide 6.12.2+)
        Configuration.holdBrowserOpen = false;

        Configuration.baseUrl = ConfigProvider.getBaseUrl();

        System.out.println("Running tests on env: " + ConfigProvider.getEnv());
        System.out.println("Base URL: " + Configuration.baseUrl);
        System.out.println("Using Selenium Grid at: " + Configuration.remote);
    }

    @BeforeEach
    public void openBasePage() {
        open("/");  // Открываем базовый URL (уже задан в Configuration.baseUrl)
    }

    @AfterAll
    public static void tearDown() {
        closeWebDriver();
    }
}