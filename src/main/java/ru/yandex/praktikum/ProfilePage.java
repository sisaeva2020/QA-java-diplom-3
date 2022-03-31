package ru.yandex.praktikum;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ProfilePage {

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Выход')]")
    public SelenideElement logOutButton;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Конструктор')]")
    public SelenideElement profilePageConstructorButton;

    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']//a//*[name()='svg']")
    public SelenideElement profilePageLogoButton;

    @Step("Click LogOut Button on ProfilePage")
    public void clickLogOutButton() {
        this.logOutButton.click();
    }

    @Step("Click Profile Page Constructor Button on ProfilePage")
    public void clickByProfilePageConstructorButton() {
        this.profilePageConstructorButton.click();
    }

    @Step("Click Profile Page Logo Button on ProfilePage")
    public void clickByProfilePageLogoButton() {
        this.profilePageLogoButton.click();
    }

    @Step("Verify LogOut Button is Displayed")
    public boolean isLogOutButtonEnabled() {
        return this.logOutButton.isEnabled();
    }
}

