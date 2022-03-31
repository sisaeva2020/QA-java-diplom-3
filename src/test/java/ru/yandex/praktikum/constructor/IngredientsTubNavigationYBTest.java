package ru.yandex.praktikum.constructor;

import io.qameta.allure.Step;
import org.junit.Test;
import ru.yandex.praktikum.BaseTestYB;
import ru.yandex.praktikum.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class IngredientsTubNavigationYBTest extends BaseTestYB {
    @Test
    @Step("Click to Sauce Tub,  Click to Bun Tub")
    public void successfulBunTubNavigation() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickSauceTub();
        mainPage.clickBunTub();
        assertTrue(mainPage.isFluorBunPictDisplayed());
    }

    @Test
    @Step("Click to Bun Tub,  Click to Sauce Tub")
    public void successfulSauceTubNavigation() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickBunTub();
        mainPage.clickSauceTub();
        assertTrue(mainPage.isSpicyXSaucePictDisplayed());
    }

    @Test
    @Step("Click to Bun Tub,  Click to Filling Tub")
    public void successfulFillingTubNavigation() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickBunTub();
        mainPage.clickFillingTub();
        assertTrue(mainPage.isProtostomiaMeatPictDisplayed());
    }
}