package ru.yandex.praktikum.switch_to_profile;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import ru.yandex.praktikum.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class SwitchFromProfileByConstructorButtonYBTest extends BaseTestYB {
    @After
    public void tearsDown() {
        UserOperations userOperations = new UserOperations();
        userOperations.delete();
    }

    @Test
    @DisplayName("Check Switch From Profile By Constructor Button YB")
    public void checkSwitchFromProfileByConstructorButton() {
        UserOperations userOperations = new UserOperations();
        Map<String, String> newCustomerData = userOperations.register();

        LoginPage loginPage = open(LoginPage.URL_LOGIN, LoginPage.class);
        loginPage.setEmailLoginField(newCustomerData.get("email"));
        loginPage.setPasswordLoginField(newCustomerData.get("password"));
        loginPage.clickLoginButton();

        MainPage mainPage = page(MainPage.class);
        mainPage.clickProfileTopButton();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickByProfilePageConstructorButton();

        assertTrue(mainPage.isConstructorButtonDisplayed());
    }
}
