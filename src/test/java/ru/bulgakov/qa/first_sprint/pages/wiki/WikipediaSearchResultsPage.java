package ru.bulgakov.qa.first_sprint.pages.wiki;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WikipediaSearchResultsPage {

    private final SelenideElement scrollToHeader = $("#External_links");
    private final SelenideElement headerName = $("a[href='https://oracle.com/java/']");
    private final SelenideElement articleTitle = $("h1.firstHeading");

    public WikipediaSearchResultsPage checkTitle(String expectedTitle) {
        articleTitle.shouldHave(exactText(expectedTitle));
        return this;
    }

    public WikipediaSearchResultsPage scrollHeader() {
        scrollToHeader.scrollTo();
        return this;
    }

    public WikipediaSearchResultsPage checkText(String expectedHeaderName) {
        headerName.shouldHave(text(expectedHeaderName));
        return this;
    }
}
