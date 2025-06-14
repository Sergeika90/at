package tests;

import com.codeborne.selenide.Configuration;
import config.ConfigProvider;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HomePageTest {
    private HomePage homePage;

    @BeforeAll
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = ConfigProvider.getBaseUrl();
        System.out.println("Running tests on env: " + ConfigProvider.getEnv());
        System.out.println("Base URL: " + Configuration.baseUrl);
    }

    @BeforeEach
    public void openPage() {
        open("https://bonigarcia.dev/selenium-webdriver-java/");
        homePage = new HomePage();
    }

    @Test
    @Description("Verify the main header text on homepage")
    public void testMainHeaderText() {
        String text = homePage.getMainHeaderText();
        assertTrue(text.contains("Selenium WebDriver"));
    }

    @Test
    @Description("Click 'Getting Started' and verify section visibility")
    public void testGettingStartedSectionVisibleAfterClick() {
        homePage.clickGettingStarted();
        assertTrue(homePage.isGettingStartedVisible());
    }

    @AfterAll
    public void tearDown() {
        closeWebDriver();
    }
}