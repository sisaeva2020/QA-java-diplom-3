package ru.yandex.praktikum.login;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class LoginWithRegistrationFormPageYBTest extends BaseTestYB {
    @Test
    @DisplayName("Check Login With Registration Form Page YB")
    public void checkLoginWithRegistrationFormPage () {
        UserOperations userOperations = new UserOperations();
        userOperations.register();

        Map<String, String> newCustomerData = userOperations.register();

        LoginPage loginPage = open(LoginPage.URL_LOGIN, LoginPage.class);

        loginPage.setEmailLoginField(newCustomerData.get("email"));
        loginPage.setPasswordLoginField(newCustomerData.get("password"));
        loginPage.clickLoginButton();

        MainPage mainPage = page(MainPage.class);

        userOperations.delete();

        assertTrue(mainPage.isConstructorButtonDisplayed());


    }
}