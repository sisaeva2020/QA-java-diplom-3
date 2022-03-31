package ru.yandex.praktikum;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {
    public static final String URL_REG = MainPage.URL + "register";

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/input[1]")
    public SelenideElement nameRegField;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/form[1]/fieldset[2]/div[1]/div[1]/input[1]")
    public SelenideElement emailRegField;

    @FindBy(how = How.CSS, using = "input[name='Пароль']")
    public SelenideElement passwordRegField;

    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    public SelenideElement regButton;

    @FindBy(how = How.XPATH, using = "//p[@class='input__error text_type_main-default']")
    public SelenideElement invalidPasswordErrorMessage;

    @Step("Set Name Field on RegistrationPage")
    public void setNameRegField(String name) {
        this.nameRegField.sendKeys(name);
    }

    @Step("Click Email Field on RegistrationPage")
    public void setEmailRegField(String email) {
        this.emailRegField.sendKeys(email);
    }

    @Step("Click Password Field on RegistrationPage")
    public void setPasswordRegField(String password) {
        this.passwordRegField.sendKeys(password);
    }

    @Step("Click Register Button on RegistrationPage")
    public void clickRegButton() {
        this.regButton.click();
    }

    @Step("Verify Invalid Password Message is Displayed")
    public boolean isInvalidPasswordMessageDisplayed() {
        return this.invalidPasswordErrorMessage.isDisplayed();
    }
}
