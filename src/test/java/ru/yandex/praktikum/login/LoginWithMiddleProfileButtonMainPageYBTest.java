package ru.yandex.praktikum.login;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class LoginWithMiddleProfileButtonMainPageYBTest extends BaseTestYB {
    @Test
    @DisplayName("Check Login With Middle Profile Button MainPage YB")
    public void checkLoginWithMiddleProfileButtonMainPage () {
        UserOperations userOperations = new UserOperations();
        userOperations.register();

        Map<String, String> newCustomerData = userOperations.register();

        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickProfileMiddleButton();

        LoginPage loginPage = page(LoginPage.class);

        loginPage.setEmailLoginField(newCustomerData.get("email"));
        loginPage.setPasswordLoginField(newCustomerData.get("password"));
        loginPage.clickLoginButton();

        userOperations.delete();

        assertTrue(mainPage.isConstructorButtonDisplayed());


    }

}
