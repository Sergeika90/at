package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class HomePage {
    private SelenideElement mainHeader = $(".display-4");
    private SelenideElement gettingStartedLink = $("a[href='web-form.html']");
    private SelenideElement gettingStartedSection = $(".display-6");

    @Step("Получить текст главного заголовка")
    public String getMainHeaderText() {
        return mainHeader.shouldBe(visible).text();
    }

    @Step("Кликнуть на ссылку 'Getting Started'")
    public void clickGettingStarted() {
        gettingStartedLink.shouldBe(visible).click();
    }

    @Step("Проверить, что секция 'Getting Started' видна")
    public boolean isGettingStartedVisible() {
        return gettingStartedSection.shouldBe(visible).exists();
    }
}
