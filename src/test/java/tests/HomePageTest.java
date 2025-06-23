package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest extends BaseTest {

    private final HomePage homePage = new HomePage();

    @Test
    @Description("Verify the main header text on homepage")
    public void testMainHeaderText() {
        Allure.step("Получаем текст главного заголовка", () -> {
            String text = homePage.getMainHeaderText();
            assertTrue(text.contains("Selenium WebDriver"), "Заголовок содержит 'Selenium WebDriver'");
        });
    }

    @Test
    @Description("Click 'Getting Started' and verify section visibility")
    public void testGettingStartedSectionVisibleAfterClick() {
        Allure.step("Кликаем по ссылке 'Getting Started'", () -> {
            homePage.clickGettingStarted();
        });

        Allure.step("Проверяем видимость секции 'Getting Started'", () -> {
            assertTrue(homePage.isGettingStartedVisible(), "Секция 'Getting Started' отображается");
        });
    }
}
