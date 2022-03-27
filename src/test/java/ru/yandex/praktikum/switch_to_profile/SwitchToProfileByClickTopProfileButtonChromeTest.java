package ru.yandex.praktikum.switch_to_profile;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.*;
import java.util.Map;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class SwitchToProfileByClickTopProfileButtonChromeTest extends BaseTestChrome {
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

        userOperations.delete();

        assertTrue(profilePage.isLogOutButtonDisplayed());


    }
}
