package ru.bulgakov.qa.ya;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class YandexSearchResultsPage {
    private final SelenideElement distributionClose = $(".DistributionButtonClose");


    public YandexSearchResultsPage closeDistributionButton() {
        sleep(3000);
        if (distributionClose.exists()) {
            distributionClose.click(); // если есть всплывающее окно, то закрыть
        }
        return this;
    }

    public WelcomePage openLink(String webSiteName) {
        $(byText(webSiteName)).click();
        return new WelcomePage();
    }
}
