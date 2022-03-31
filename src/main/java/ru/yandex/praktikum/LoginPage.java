package ru.yandex.praktikum;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static ru.yandex.praktikum.MainPage.URL;

public class LoginPage {
    public static final String URL_LOGIN = URL + "login";

    @FindBy(how = How.CSS, using = "input[name='name']")
    public SelenideElement emailLoginField;

    @FindBy(how = How.CSS, using = "input[name='Пароль']")
    public SelenideElement passwordLoginField;

    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    public SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Восстановить пароль')]")
    public SelenideElement forgotPasswordButton;

    @Step("Set Email on Login Page")
    public void setEmailLoginField(String email) {
        this.emailLoginField.sendKeys(email);
    }

    @Step("Set Password on Login Page")
    public void setPasswordLoginField(String password) {
        this.passwordLoginField.sendKeys(password);
    }

    @Step("Click LoginButton on Login Page")
    public void clickLoginButton() {
        this.loginButton.click();
    }

    @Step("Verify EmailButton is Displayed")
    public boolean isEmailButtonDisplayed() {
        return this.emailLoginField.isDisplayed();
    }

    @Step("Click Login Forgot Password Button on Login Page")
    public void clickLoginForgotPasswordButton() {
        this.forgotPasswordButton.click();
    }
}