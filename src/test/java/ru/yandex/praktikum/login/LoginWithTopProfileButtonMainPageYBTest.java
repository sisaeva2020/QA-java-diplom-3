package ru.yandex.praktikum.login;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import ru.yandex.praktikum.BaseTestYB;
import ru.yandex.praktikum.LoginPage;
import ru.yandex.praktikum.MainPage;
import ru.yandex.praktikum.UserOperations;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class LoginWithTopProfileButtonMainPageYBTest extends BaseTestYB {
    @After
    public void tearsDown() {
        UserOperations userOperations = new UserOperations();
        userOperations.delete();
    }

    @Test
    @DisplayName("Check Login With Top Profile Button MainPage YB")
    public void checkLoginWithTopProfileButtonMainPage() {
        UserOperations userOperations = new UserOperations();
        userOperations.register();

        Map<String, String> newCustomerData = userOperations.register();

        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickProfileTopButton();

        LoginPage loginPage = page(LoginPage.class);

        loginPage.setEmailLoginField(newCustomerData.get("email"));
        loginPage.setPasswordLoginField(newCustomerData.get("password"));
        loginPage.clickLoginButton();

        assertTrue(mainPage.isConstructorButtonDisplayed());
    }
}
