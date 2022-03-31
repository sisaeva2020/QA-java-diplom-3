package ru.yandex.praktikum;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ForgotPasswordPage {
    @FindBy(how = How.XPATH, using = "//a[@class='Auth_link__1fOlj']")
    public SelenideElement forgotPasswordLoginButton;

    @Step("Click Forgot Password Button on Forgot Password Page")
    public void clickForgotPasswordLoginButton() {
        this.forgotPasswordLoginButton.click();
    }
}
