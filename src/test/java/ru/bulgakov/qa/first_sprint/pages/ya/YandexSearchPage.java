package ru.bulgakov.qa.first_sprint.pages.ya;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YandexSearchPage {
    private final SelenideElement searchInput = $("#text");

    public YandexSearchResultsPage search(String query) {
        searchInput.setValue(query);
        searchInput.pressEnter();
        return new YandexSearchResultsPage();
    }
}
