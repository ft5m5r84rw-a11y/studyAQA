package ru.bulgakov.qa.wiki;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

public class WikipediaSearchResults {

    private final SelenideElement scrollToHeader = $("#External_links");
    private final SelenideElement headerName = $("#mwCEw");



    public WikipediaSearchResults scrollHeader() {
        scrollToHeader.scrollTo();
        return this;
    }
    public WikipediaSearchResults checkText(String expectedHeaderName) {
        headerName.shouldHave(text(expectedHeaderName));
        return this;
    }
}
