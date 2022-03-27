package ru.yandex.praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ForgotPasswordPage {

    @FindBy(how = How.XPATH, using = "//a[@class='Auth_link__1fOlj']")
    public SelenideElement forgotPasswordLoginButton;

    public void clickForgotPasswordLoginButton() { this.forgotPasswordLoginButton.click(); }


}
