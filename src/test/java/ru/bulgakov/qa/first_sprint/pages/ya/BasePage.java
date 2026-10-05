package ru.bulgakov.qa.first_sprint.pages.ya;

import static com.codeborne.selenide.Selenide.switchTo;

public class BasePage {
    public void switchToWindow(int index) {
        switchTo().window(index);
    }
}
