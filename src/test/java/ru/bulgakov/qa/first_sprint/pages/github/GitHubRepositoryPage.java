package ru.bulgakov.qa.first_sprint.pages.github;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GitHubRepositoryPage {
    private final SelenideElement wikiButton = $(byText("Wiki"));
    private final SelenideElement repositoryName = $("[data-testid='repo-name-link']");

    @Step("Проверить название репозитория: {expectedName}")
    public GitHubRepositoryPage checkRepositoryName(String expectedName) {
        repositoryName.shouldHave(text(expectedName));
        return this;
    }

    @Step("Открыть вкладку Wiki репозитория")
    public GitHubWikiPage clickWiki() {
        wikiButton.click();
        return new GitHubWikiPage();
    }
}
