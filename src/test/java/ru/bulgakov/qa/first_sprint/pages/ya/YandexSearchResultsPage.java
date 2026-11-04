package ru.bulgakov.qa.first_sprint.pages.ya;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexSearchResultsPage {
    private final SelenideElement distributionClose = $(".DistributionButtonClose");
    private final ElementsCollection webSiteName = $$("a[href='https://ivanbulgakovqa.ru/']");

    @Step("Закрыть предложение сделать браузер основным")
    public YandexSearchResultsPage closeDistributionButton() {
        if (distributionClose.is(visible, Duration.ofSeconds(2))) {
            distributionClose.click();
        }
        return this;
    }

    @Step("Открыть сайт из результатов поиска")
    public WelcomePage openLink() {
        webSiteName.filterBy(visible)
                .first()
                .click();
        return new WelcomePage();
    }
}
