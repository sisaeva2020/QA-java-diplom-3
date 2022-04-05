package ru.yandex.praktikum.switch_to_profile;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import com.UserOperations;
import ru.yandex.praktikum.BaseTestChrome;
import ru.yandex.praktikum.LoginPage;
import ru.yandex.praktikum.MainPage;
import ru.yandex.praktikum.ProfilePage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class SwitchToProfileByClickTopProfileButtonChromeTest extends BaseTestChrome {
    @After
    public void tearsDown() {
        UserOperations userOperations = new UserOperations();
        userOperations.delete();
    }

    @Test
    @DisplayName("Check Switch To Profile By Click Top Profile Button Chrome")
    public void checkSwitchToProfileByClickTopProfileButton() {
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

        assertTrue(profilePage.isLogOutButtonEnabled());
    }
}
