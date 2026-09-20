package ru.bulgakov.qa.first_sprint.pages.github;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;

public class GitHubRepositoryPage {
    private final SelenideElement searchResults = $(".Users-module__titleLoginText__J6lmd");
    private final SelenideElement nameRepositories = $(".Box-row a");
    private final SelenideElement clikRepositories = $(".repo");
    private final SelenideElement wikiButton = $(byText("Wiki"));
    private final SelenideElement wikiTab = $("#wiki-wrapper");


    public GitHubRepositoryPage resultsUsers() {
        searchResults.click();
        return this;
    }

    public GitHubRepositoryPage checkRepositories(String expectedName) {
        nameRepositories.shouldHave(text(expectedName)).click();
        return this;
    }

    public GitHubRepositoryPage clickWiki() {
        wikiButton.click();
        return this;
    }
    public GitHubRepositoryPage checkPage(String expectedPage) {
        wikiTab.shouldHave(text(expectedPage)).click();
        return this;
    }

}
