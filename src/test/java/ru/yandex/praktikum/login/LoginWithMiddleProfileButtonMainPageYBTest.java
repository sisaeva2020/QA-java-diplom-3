package ru.yandex.praktikum.login;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import ru.yandex.praktikum.BaseTestYB;
import ru.yandex.praktikum.LoginPage;
import ru.yandex.praktikum.MainPage;
import com.UserOperations;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class LoginWithMiddleProfileButtonMainPageYBTest extends BaseTestYB {
    @After
    public void tearsDown() {
        UserOperations userOperations = new UserOperations();
        userOperations.delete();
    }

    @Test
    @DisplayName("Check Login With Middle Profile Button MainPage YB")
    public void checkLoginWithMiddleProfileButtonMainPage() {
        UserOperations userOperations = new UserOperations();
        userOperations.register();

        Map<String, String> newCustomerData = userOperations.register();

        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickProfileMiddleButton();

        LoginPage loginPage = page(LoginPage.class);

        loginPage.setEmailLoginField(newCustomerData.get("email"));
        loginPage.setPasswordLoginField(newCustomerData.get("password"));
        loginPage.clickLoginButton();

        assertTrue(mainPage.isConstructorButtonDisplayed());
    }
}
