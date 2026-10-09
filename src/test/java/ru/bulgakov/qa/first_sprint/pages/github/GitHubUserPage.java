package ru.bulgakov.qa.first_sprint.pages.github;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class GitHubUserPage {
    private final ElementsCollection nameRepositories = $$(".Box-row a");

    @Step("Проверить наличие репозитория «{name}» в профиле пользователя")
    public GitHubUserPage checkRepository(String name) {
        nameRepositories.findBy(exactText(name)).shouldBe(visible);
        return this;
    }

    @Step("Открыть репозиторий «{name}»")
    public GitHubRepositoryPage openRepository(String name) {
        nameRepositories.findBy(exactText(name)).click();
        return new GitHubRepositoryPage();
    }
}
