package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Web Tests")
@Feature("Main Page")
public class HomePageTest extends BaseTest {
    HomePage homePage = new HomePage();
    @Test
    @Story("Header Validation")
    @Severity(SeverityLevel.CRITICAL)
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
