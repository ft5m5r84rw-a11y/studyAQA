package ru.bulgakov.qa.first_sprint.pages.wiki;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class WikipediaSearchPage {
    private final SelenideElement languageList = $("#searchLanguage");
    private final SelenideElement searchInput = $("#searchInput");
    private final SelenideElement clickSearchButton = $x("/html/body/main/div[2]/form/fieldset/div/div[2]/div/a[3]");

    public WikipediaSearchPage dropDownLanguageList() {
        sleep(3000);
        languageList.selectOption("English");
        return this;
    }

    public WikipediaSearchPage search(String input) {
        searchInput.setValue(input);
        return this;
    }

    public WikipediaSearchResultsPage searchQuery() {
        clickSearchButton.click();
        return new WikipediaSearchResultsPage();
    }
}
