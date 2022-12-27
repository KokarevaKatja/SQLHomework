package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {


    public DashboardPage() {
        heading.shouldBe(visible);
    }

    private SelenideElement heading = $("[data-test-id=dashboard]");

}


