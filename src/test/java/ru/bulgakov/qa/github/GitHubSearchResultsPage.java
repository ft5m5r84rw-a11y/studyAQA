package ru.bulgakov.qa.github;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Selenide.sleep;

public class GitHubSearchResultsPage {
    private final SelenideElement groupList = $("#_r_8_--label");


    public GitHubRepositoryPage usersTopic() {
        sleep(10000);
        groupList.click();
        return new GitHubRepositoryPage();
    }


}
