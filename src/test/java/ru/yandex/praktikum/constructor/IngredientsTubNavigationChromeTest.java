package ru.yandex.praktikum.constructor;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.BaseTestChrome;
import ru.yandex.praktikum.MainPage;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;

public class IngredientsTubNavigationChromeTest extends BaseTestChrome {

    @Test
    @DisplayName("Check Bun Tub Navigation Chrome")
    public void IngredientsTubNavigationTestChrome () {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickBunTub();
        mainPage.clickSauceTub();
        mainPage.clickFillingTub();

        assertTrue(mainPage.isFluorBunPictDisplayed());
        assertTrue(mainPage.isSpicyXSaucePictDisplayed());
        assertTrue(mainPage.isProtostomiaMeatPictDisplayed());


    }
}