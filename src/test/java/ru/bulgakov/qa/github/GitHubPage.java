package ru.bulgakov.qa.github;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GitHubPage {
    private final SelenideElement clickSearchButton = $(".HeaderSearch-module__label__d1iWG");
    private final SelenideElement searchInput = $("[placeholder='Search or jump to...']");

    public GitHubPage clickSearch() {
        clickSearchButton.click();
        return this;
    }

    public GitHubSearchResultsPage search(String query) {
        searchInput.setValue(query).pressEnter();
        return new GitHubSearchResultsPage();
    }



}
