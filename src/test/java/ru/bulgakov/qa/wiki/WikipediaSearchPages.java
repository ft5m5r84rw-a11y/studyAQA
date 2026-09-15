package ru.bulgakov.qa.wiki;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class WikipediaSearchPages {
    private final SelenideElement languageList = $("#searchLanguage");
    private final SelenideElement searchInput = $("#searchInput");
    private final SelenideElement clickSearchButton = $x("/html/body/main/div[2]/form/fieldset/div/div[2]/div/a[3]");



    public WikipediaSearchPages dropDownLanguageList() {
        sleep(3000);
        languageList.selectOption("English");
        return this;
    }

    public WikipediaSearchPages search(String input) {
        searchInput.setValue(input);
        return this;
    }

    public WikipediaSearchResults searchQuery() {
        clickSearchButton.click();
        return new WikipediaSearchResults();
    }


    }
