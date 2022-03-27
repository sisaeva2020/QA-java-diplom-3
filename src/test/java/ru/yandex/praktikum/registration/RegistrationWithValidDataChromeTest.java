package ru.yandex.praktikum.registration;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import ru.yandex.praktikum.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class RegistrationWithValidDataChromeTest extends BaseTestChrome {
    @Test
    @DisplayName("Check Registration With Valid Data Chrome")
    public void checkRegistrationWithValidData () {
        final String name = RandomStringUtils.randomAlphabetic(8);
        final String email = RandomStringUtils.randomAlphabetic(10) + "@test.ru";
        final String password = RandomStringUtils.randomNumeric(6);

        RegistrationPage registrationPage = open(RegistrationPage.URL_REG, RegistrationPage.class);

        registrationPage.setNameRegField(name);
        registrationPage.setEmailRegField(email);
        registrationPage.setPasswordRegField(password);
        registrationPage.clickRegButton();

        LoginPage loginPage = page(LoginPage.class);

        DeleteCustomerAPI deleteCustomerAPI = new DeleteCustomerAPI();
        deleteCustomerAPI.deleteCustomerByEmailAndPassword(email, password);

        assertTrue(loginPage.isEmailButtonDisplayed());



    }
}

