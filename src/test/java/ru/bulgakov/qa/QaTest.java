package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class QaTest {

    @Test
    void mentoringPriceShouldBe47000Test() {

        /*
        *1. открыть поисковик
        *2. ввести данные сайта
        *3. нажать кнопку поиска
        *4. в поисковой выдачен найти нужный сайт и кликнуть на него
        *5. нажать нв кнопку "стоимость"
        *6. нажать на кнопку "хочу вкатиться в IT"
        *7. нажать на кнопку "бегу оплачивать"
        *8. проверить, что к оплате 47000 рублей
         */
        Configuration.holdBrowserOpen = true;

        open("https://ya.ru"); // открыть яндекс
        $("#text").setValue("bulgakov qa"); // ввести bulgakov qa

        if ($(".DistributionButtonClose_view_button").exists()) {
            $(".DistributionButtonClose_view_button").click(); // если есть всплывающее окно, то закрыть
        }

        $("#text").click();

        if ($(".mini-suggest__search-button").exists()) {
            $(".mini-suggest__search-button").click(); // если нет кнопки, то через "искать в поиске"
        }

        if ($(".mini-suggest__item").exists()) {
            $(".mini-suggest__item").click(); // если нет кнопки и всего остального, то из выпадающего списка
        }


        if ($(".button.search3__button").exists()) {
            $(".button.search3__button").click(); // если есть кнопка поиска, то через нее
        }

        sleep(3000);
        if ($(".DistributionButtonClose").exists()) {
            $(".DistributionButtonClose").click(); // если есть всплывающее окно, то закрыть
        }

        $(byText("ivanbulgakovqa.ru")).click();

        sleep(3000);
        switchTo().window(1);
        $$(".t-menu__list li").last().click();
        $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a/div").click();
        $(byText("Бегу оплачивать")).click();

        switchTo().window(2);
        sleep(3000);
        $(".styles-module-scss-module__knQhiq__aside h3").shouldHave(text("₽ 47 000.00"));




    }

   /* Too many requests
   @Test
    void homeworkTest() {
        *//*
     * 1. искать по url https://github.com
     * 2. кликнуть на поиск java-automation-qa
     * 3. ввести Search syntax tips
     * 4. имитировать нажатие enter ??
     * 5. кликнуть на users
     * 6. кликнуть java-automation-qa
     * 7. перейти getting-started
     * 8. перейти src/test/java
     * 9. перейти в wiki
     * 10. проверить что есть 1. Установка Java

         *//*

        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";


 open("https://github.com");
        $(".HeaderSearch-module__label__d1iWG").click();
        $("[placeholder='Search or jump to...']").setValue("java-automation-qa").pressEnter();
        sleep(3000);
        $("#_r_8_--label").click();
        $(".Users-module__titleLoginText__J6lmd").click();
        $(".Box-row a").shouldHave(text("getting-started"));
        $(".Box-row").click();
        }*/

@Test
    void secondHomeworkTest() {
    Configuration.holdBrowserOpen = true;

    open("https://www.wikipedia.org/");
    sleep(3000);
    $("#searchLanguage").selectOption("English");
    $("#searchInput").setValue("Java");
    $x("/html/body/main/div[2]/form/fieldset/div/div[2]/div/a[3]").click();
    $("#External_links").scrollTo();
    $("#mwCEw").shouldHave(text("Java Software, Oracle"));





    }



}





