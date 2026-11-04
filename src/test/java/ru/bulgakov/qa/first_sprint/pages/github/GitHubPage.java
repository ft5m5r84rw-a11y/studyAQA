package ru.bulgakov.qa.first_sprint.pages.github;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.$;

public class GitHubPage {
    private final SelenideElement clickSearchButton = $("[data-analytics-event*='searchbar']");
    private final SelenideElement searchInput = $("[placeholder='Search or jump to...']");

    @Step("Открыть поисковую строку GitHub")
    public GitHubPage clickSearch() {
        clickSearchButton.click();
        return this;
    }

    @Step("Выполнить поиск в GitHub по запросу: {query}")
    public GitHubSearchResultsPage search(String query) {
        searchInput.setValue(query).pressEnter();
        return new GitHubSearchResultsPage();
    }
}
