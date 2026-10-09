package ru.bulgakov.qa.first_sprint.test;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.bulgakov.qa.first_sprint.pages.github.GitHubPage;
import ru.bulgakov.qa.first_sprint.pages.wiki.WikipediaSearchPage;
import ru.bulgakov.qa.first_sprint.pages.ya.YandexSearchPage;
import webshop.test.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;

public class QaTest extends TestBase {

    private static final String YANDEX_URL = "https://ya.ru";
    private static final String GITHUB_URL = "https://github.com";
    private static final String WIKIPEDIA_URL = "https://www.wikipedia.org/";

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Проверка стоимости обучения QA — 47 000 рублей")
    @Severity(CRITICAL)
    @Owner("polina_solnyshkina")
    @Link(name = "TASK-001", url = "https://")
    void mentoringPriceShouldBe47000Test() {
        open(YANDEX_URL, YandexSearchPage.class)
                .search("bulgakov qa")
                .closeDistributionButton()
                .openLink()
                .switchToWelcomeWindow(1)
                .clickMenu()
                .clickStartQaButton()
                .clickPaymentButton()
                .switchToPaymentWindow(2)
                .checkPageTitle("Трудоустройство в QA 47000р.")
                .checkPriceAmout("₽ 47 000.00");


    }

    @Test
    @DisplayName("Проверка отображения инструкции по установке Java в Wiki репозитория")
    @Severity(NORMAL)
    @Owner("polina_solnyshkina")
    @Link(name = "TASK-002", url = "https://")
    void gettingStartedWikiPageShouldBeDisplayedTest() {
        open(GITHUB_URL, GitHubPage.class)
                .clickSearch()
                .search("java-automation-qa")
                .usersTopic()
                .resultsUsers()  // почему-то иногда кликает на "discussions"
                .checkRepository("getting-started")
                .openRepository("getting-started")
                .checkRepositoryName("getting-started")
                .clickWiki()
                .checkPage("1. Установка Java");

    }

    @Test
    @DisplayName("Проверка наличия статьи в Wikipedia")
    @Severity(NORMAL)
    @Owner("polina_solnyshkina")
    @Link(name = "TASK-003", url = "https://")
    void oracleJavaLinkShouldBeDisplayedTest() {
        open(WIKIPEDIA_URL, WikipediaSearchPage.class)
                .dropDownLanguageList()
                .search("Java")
                .searchQuery()
                .checkTitle("Java (programming language)")
                .scrollHeader()
                .checkText("Java Software, Oracle");

    }

}





