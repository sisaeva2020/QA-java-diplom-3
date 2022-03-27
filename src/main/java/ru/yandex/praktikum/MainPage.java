package ru.yandex.praktikum;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    public SelenideElement profileMiddleButton;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Личный Кабинет')]")
    public SelenideElement profileTopButton;

    @FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[@class='App_App__aOmNj']/main[@class='App_componentContainer__2JC2W']/section[@class='BurgerIngredients_ingredients__1N8v2']/div[1]")
    public SelenideElement bunTub;

    @FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[@class='App_App__aOmNj']/main[@class='App_componentContainer__2JC2W']/section[@class='BurgerIngredients_ingredients__1N8v2']/div[1]")
    public SelenideElement sauceTub;

    @FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[@class='App_App__aOmNj']/main[@class='App_componentContainer__2JC2W']/section[@class='BurgerIngredients_ingredients__1N8v2']/div[1]")
    public SelenideElement fillingTub;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Конструктор')]")
    public SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']//a//*[name()='svg']")
    public SelenideElement fluorBunPict;

    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']//a//*[name()='svg']")
    public SelenideElement spicyXSaucePict;

    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']//a//*[name()='svg']")
    public SelenideElement protostomiaMeatPict;



    public void clickProfileMiddleButton() { this.profileMiddleButton.click(); }
    public void clickProfileTopButton() { this.profileTopButton.click(); }
    public void clickBunTub() { this.bunTub.click(); }
    public void clickSauceTub() { this.sauceTub.click(); }
    public void clickFillingTub() { this.fillingTub.click(); }
    public boolean isConstructorButtonDisplayed() { return this.constructorButton.isDisplayed(); }
    public boolean isFluorBunPictDisplayed() { return this.fluorBunPict.isDisplayed(); }
    public boolean isSpicyXSaucePictDisplayed() { return this.spicyXSaucePict.isDisplayed(); }
    public boolean isProtostomiaMeatPictDisplayed() { return this.protostomiaMeatPict.isDisplayed(); }


}
