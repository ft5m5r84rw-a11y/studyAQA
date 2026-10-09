package ru.bulgakov.qa.first_sprint.pages.ya;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class YandexSearchPage {
    private final SelenideElement searchInput = $("#text");

    @Step("Выполнить поиск по запросу: {query}")
    public YandexSearchResultsPage search(String query) {
        searchInput.setValue(query);
        searchInput.pressEnter();
        return new YandexSearchResultsPage();
    }
}
