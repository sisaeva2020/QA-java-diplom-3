package ru.yandex.praktikum.logout;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import com.UserOperations;
import ru.yandex.praktikum.BaseTestYB;
import ru.yandex.praktikum.LoginPage;
import ru.yandex.praktikum.MainPage;
import ru.yandex.praktikum.ProfilePage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class SuccessfulLogoutWithLogoutButtonYBTest extends BaseTestYB {
    @After
    public void tearsDown() {
        UserOperations userOperations = new UserOperations();
        userOperations.delete();
    }

    @Test
    @DisplayName("Check Successful Logout With Logout Button YB")
    public void checkSuccessfulLogoutWithLogoutButton() {
        UserOperations userOperations = new UserOperations();
        Map<String, String> newCustomerData = userOperations.register();

        LoginPage loginPage = open(LoginPage.URL_LOGIN, LoginPage.class);
        loginPage.setEmailLoginField(newCustomerData.get("email"));
        loginPage.setPasswordLoginField(newCustomerData.get("password"));
        loginPage.clickLoginButton();

        MainPage mainPage = page(MainPage.class);
        mainPage.clickProfileTopButton();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickLogOutButton();

        assertTrue(loginPage.isEmailButtonDisplayed());
    }
}
