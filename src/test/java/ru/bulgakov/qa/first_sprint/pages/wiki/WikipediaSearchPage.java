package ru.bulgakov.qa.first_sprint.pages.wiki;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class WikipediaSearchPage {
    private final SelenideElement languageList = $("#searchLanguage");
    private final SelenideElement searchInput = $("#searchInput");
    private final SelenideElement clickSearchButton = $x("/html/body/main/div[2]/form/fieldset/div/div[2]/div/a[3]");

    @Step("Выбрать английский язык в выпадающем списке")
    public WikipediaSearchPage dropDownLanguageList() {
        languageList.selectOption("English");
        return this;
    }

    @Step("Ввести поисковый запрос: {input}")
    public WikipediaSearchPage search(String input) {
        searchInput.setValue(input);
        return this;
    }

    @Step("Нажать кнопку поиска Wikipedia")
    public WikipediaSearchResultsPage searchQuery() {
        clickSearchButton.click();
        return new WikipediaSearchResultsPage();
    }
}
