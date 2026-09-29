package ru.bulgakov.qa.first_sprint.pages.github;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class GitHubWikiPage {
    private final SelenideElement wikiTab = $("#wiki-wrapper");

    public GitHubWikiPage checkPage(String name) {
        wikiTab.shouldHave(text(name));
        return this;
    }
}
