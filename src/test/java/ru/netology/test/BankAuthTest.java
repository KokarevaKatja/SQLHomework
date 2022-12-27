package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

import java.sql.SQLException;

public class BankAuthTest {

    @AfterEach
    void tearDown() {
        SQLHelper.cleanDB();
    }

    @Test
    public void successAuth() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getCorrectAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        verificationPage.VerificationPageVisible();
        val verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }
}

