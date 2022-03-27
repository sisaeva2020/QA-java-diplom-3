package ru.yandex.praktikum;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ProfilePage {

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Выход')]")
    public SelenideElement logOutButton;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Конструктор')]")
    public SelenideElement profilePageConstructorButton;

    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']//a//*[name()='svg']")
    public SelenideElement profilePageLogoButton;

    public void clickLogOutButton() { this.logOutButton.click(); }
    public void clickByProfilePageConstructorButton() { this.profilePageConstructorButton.click(); }
    public void clickByProfilePageLogoButton() { this.profilePageLogoButton.click(); }
    public boolean isLogOutButtonDisplayed() { return this.logOutButton.isDisplayed(); }
}

