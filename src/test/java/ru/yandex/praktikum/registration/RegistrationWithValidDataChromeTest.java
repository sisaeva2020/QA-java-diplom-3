package ru.yandex.praktikum.registration;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import ru.yandex.praktikum.BaseTestChrome;
import ru.yandex.praktikum.DeleteCustomerAPI;
import ru.yandex.praktikum.LoginPage;
import ru.yandex.praktikum.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class RegistrationWithValidDataChromeTest extends BaseTestChrome {
    final String name = RandomStringUtils.randomAlphabetic(8);
    final String email = RandomStringUtils.randomAlphabetic(10) + "@test.ru";
    final String password = RandomStringUtils.randomNumeric(6);


    @After
    public void tearsDown() {
        DeleteCustomerAPI deleteCustomerAPI = new DeleteCustomerAPI();
        deleteCustomerAPI.deleteCustomerByEmailAndPassword(email, password);
    }

    @Test
    @DisplayName("Check Registration With Valid Data Chrome")
    public void checkRegistrationWithValidData() {
        RegistrationPage registrationPage = open(RegistrationPage.URL_REG, RegistrationPage.class);

        registrationPage.setNameRegField(name);
        registrationPage.setEmailRegField(email);
        registrationPage.setPasswordRegField(password);
        registrationPage.clickRegButton();

        LoginPage loginPage = page(LoginPage.class);
        assertTrue(loginPage.isEmailButtonDisplayed());
    }
}

