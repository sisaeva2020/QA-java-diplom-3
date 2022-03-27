package ru.yandex.praktikum.login;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.*;
import java.util.Map;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class LoginWithForgotPasswordPageChromeTest extends BaseTestChrome {
    @Test
    @DisplayName("Check Login With Forgot Password Page Chrome")
    public void checkLoginWithForgotPasswordPage () {

        UserOperations userOperations = new UserOperations();
        userOperations.register();

        Map<String, String> newCustomerData = userOperations.register();

        LoginPage loginPage = open(LoginPage.URL_LOGIN, LoginPage.class);
        loginPage.clickLoginForgotPasswordButton();

        ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
        forgotPasswordPage.clickForgotPasswordLoginButton();

        loginPage.setEmailLoginField(newCustomerData.get("email"));
        loginPage.setPasswordLoginField(newCustomerData.get("password"));
        loginPage.clickLoginButton();

        MainPage mainPage = page(MainPage.class);

        userOperations.delete();

        assertTrue(mainPage.isConstructorButtonDisplayed());

    }

}