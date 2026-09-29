package ru.bulgakov.qa.first_sprint.pages.github;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GitHubSearchResultsPage {
    private final SelenideElement groupList = $(byText("Users"));
    private final SelenideElement searchResults = $(".Users-module__titleLoginText__J6lmd");


    public GitHubSearchResultsPage usersTopic() {
        groupList.click();
        return this;
    }

    public GitHubUserPage resultsUsers() {
        searchResults.click();
        return new GitHubUserPage();
    }
}
