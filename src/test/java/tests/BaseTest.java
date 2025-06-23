package tests;

import com.codeborne.selenide.Configuration;
import config.ConfigProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
//import io.github.bonigarcia.wdm.WebDriverManager;


import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        //WebDriverManager.chromedriver().setup();  // вот эта строка отвечает за автоматическую установку драйвера

        Configuration.browser = "chrome";
        Configuration.browserCapabilities = new ChromeOptions()
                .addArguments("--headless=new")
                .addArguments("--disable-gpu")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage");

        Configuration.baseUrl = ConfigProvider.getBaseUrl();
        System.out.println("Running tests on env: " + ConfigProvider.getEnv());
        System.out.println("Base URL: " + Configuration.baseUrl);
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