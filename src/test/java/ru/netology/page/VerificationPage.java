package ru.netology.page;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class VerificationPage {

    private SelenideElement code = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public void VerificationPageVisible() {
        code.shouldBe(Condition.visible);
    }

    public void ErrorNotificationVisible() {
        errorNotification.shouldBe(Condition.visible);
    }

    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return page(DashboardPage.class);
    }

    public void verify(String verificationCode) {
        code.setValue(verificationCode);
        verifyButton.click();
    }
}