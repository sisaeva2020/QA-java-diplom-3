package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;


public class BaseTestChrome {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
}
