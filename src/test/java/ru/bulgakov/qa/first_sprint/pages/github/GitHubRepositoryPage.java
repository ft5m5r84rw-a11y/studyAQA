package ru.bulgakov.qa.first_sprint.pages.github;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GitHubRepositoryPage {
    private final SelenideElement wikiButton = $(byText("Wiki"));
    private final SelenideElement repositoryName = $("strong[itemprop='name']");

    public GitHubRepositoryPage checkRepositoryName(String expectedName) {
        repositoryName.shouldHave(text(expectedName));
        return this;
    }

    public GitHubWikiPage clickWiki() {
        wikiButton.click();
        return new GitHubWikiPage();
    }
}
