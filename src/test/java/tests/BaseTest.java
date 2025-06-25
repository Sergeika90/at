package tests;

import com.codeborne.selenide.Configuration;
import config.ConfigProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;


import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";

        // Настроим ChromeOptions с нужными параметрами
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        Configuration.browserCapabilities = options;

        // Укажем URL Selenium Grid хаба
        Configuration.remote = "http://selenium-hub:4444";

        Configuration.baseUrl = ConfigProvider.getBaseUrl();

        System.out.println("Running tests on env: " + ConfigProvider.getEnv());
        System.out.println("Base URL: " + Configuration.baseUrl);
        System.out.println("Using Selenium Grid at: " + Configuration.remote);
    }


    @BeforeEach
    public void openBasePage() {
        open("https://bonigarcia.dev/selenium-webdriver-java/");
    }

    @AfterAll
    public static void tearDown() {
        closeWebDriver();
    }
}