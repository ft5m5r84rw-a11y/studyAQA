package ru.bulgakov.qa.first_sprint.pages.github;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GitHubSearchResultsPage {
    private final SelenideElement groupList = $(byText("Users"));
    private final SelenideElement searchResults = $(".Users-module__titleLoginText__J6lmd");


    @Step("Перейти в раздел «Users» в результатах поиска")
    public GitHubSearchResultsPage usersTopic() {
        groupList.click();
        return this;
    }

    @Step("Открыть профиль пользователя из результатов поиска")
    public GitHubUserPage resultsUsers() {
        searchResults.click();
        return new GitHubUserPage();
    }
}
