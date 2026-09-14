package ru.bulgakov.qa.ya;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YandexSearchPage {
    private final SelenideElement searchInput = $("#text");
    private final SelenideElement distributionButton = $(".DistributionButtonClose_view_button");
    private final SelenideElement suggestButton = $(".mini-suggest__search-button");
    private final SelenideElement suggestItem = $(".mini-suggest__item");
    private final SelenideElement searchButton = $(".button.search3__button");




    public YandexSearchPage search(String query) {
        searchInput.setValue(query);
        return this;
    }

    public YandexSearchPage clickSearch() {
        searchInput.click();
        return this;
    }



    public YandexSearchPage closePopup() {
        if (distributionButton.exists()) {
            distributionButton.click(); // если есть всплывающее окно, то закрыть

        }
        return this;
    }

    public YandexSearchPage clickSearchButton() {
        if (suggestButton.exists()) {
            suggestButton.click(); // если нет кнопки, то через "искать в поиске"

        }
        return this;
    }

    public YandexSearchPage closeItem() {
        if (suggestItem.exists()) {
            suggestItem.click(); // если нет кнопки и всего остального, то из выпадающего списка
        }
        return this;
    }

    public YandexSearchPage closeSearchButton() {
        if (searchButton.exists()) {
            searchButton.click(); //если есть кнопка поиска, то через нее
        }
        return this;
    }

    public YandexSearchResultsPage submit() {

        if (suggestButton.exists()) {
            suggestButton.click();
        }

        if (suggestItem.exists()) {
            suggestItem.click();
        }

        if (searchButton.exists()) {
            searchButton.click();
        }

        return new YandexSearchResultsPage();
    }





}
