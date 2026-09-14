package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import ru.bulgakov.qa.github.GitHubPage;
import ru.bulgakov.qa.wiki.WikipediaSearchPages;
import ru.bulgakov.qa.ya.WelcomePage;
import ru.bulgakov.qa.ya.YandexSearchPage;
import ru.bulgakov.qa.ya.YandexSearchResultsPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class QaTest {

    @Test
    void mentoringPriceShouldBe47000Test() {
        Configuration.holdBrowserOpen = true;
        open("https://ya.ru", YandexSearchPage.class)
                .search("bulgakov qa")
                .closePopup()
                .clickSearch()
                .submit()
                .closeDistributionButton()
                .openLink("ivanbulgakovqa.ru")
                .clickMenu()
                .clickStartQaButton()
                .clickPaymentButton()
                .verifiedPrice("₽ 47 000.00");


    }


    @Test
    void homeworkTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        open("https://github.com", GitHubPage.class)
                .clickSearch()
                .search("java-automation-qa")
                .usersTopic()
                .resultsUsers()  // почему-то иногда кликает на "discussions"
                .checkRepositories("getting-started")
                .clickWiki()
                .checkPage("1. Установка Java");

    }



    @Test
    void secondHomeworkTest() {
        open("https://www.wikipedia.org/", WikipediaSearchPages.class)
                .dropDownLanguageList()
                .search("Java")
                .searchQuery()
                .scrollHeader()
                .checkText("Java Software, Oracle");

    }


}





