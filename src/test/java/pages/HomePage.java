package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.SelenideElement;

public class HomePage {
    private SelenideElement mainHeader = $(".display-4");
    private SelenideElement gettingStartedLink = $("a[href='web-form.html']");
    private SelenideElement gettingStartedSection = $(".display-6");

    public String getMainHeaderText() {
        return mainHeader.shouldBe(visible).text();
    }

    public void clickGettingStarted() {
        gettingStartedLink.shouldBe(visible).click();
    }

    public boolean isGettingStartedVisible() {
        return gettingStartedSection.shouldBe(visible).exists();
    }
}
