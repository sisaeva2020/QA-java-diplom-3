package ru.yandex.praktikum.registration;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import ru.yandex.praktikum.BaseTestChrome;
import ru.yandex.praktikum.RegistrationPage;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegistrationWithInvalidPasswordChromeTest extends BaseTestChrome {
    @Test
    @DisplayName("Check Registration With Invalid Password Chrome")
    public void checkRegistrationWithInvalidPassword () {
        final String name = RandomStringUtils.randomAlphabetic(8);
        final String email = RandomStringUtils.randomAlphabetic(10) + "@test.ru";
        final String password = RandomStringUtils.randomNumeric(5);

        RegistrationPage registrationPage = open(RegistrationPage.URL_REG, RegistrationPage.class);

        registrationPage.setNameRegField(name);
        registrationPage.setEmailRegField(email);
        registrationPage.setPasswordRegField(password);
        registrationPage.clickRegButton();

        assertTrue(registrationPage.isInvalidPasswordMessageDisplayed());

    }
}

