package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class BaseTestYB {

    @Before
    public void startUp() {

        System.setProperty("webdriver.opera.driver", "C:\\Users\\Cvetik\\QA-java-diplom-3\\testselenium\\drivers\\operadriver.exe");
        OperaOptions options = new OperaOptions();
        options.setBinary("C:\\Users\\Slav\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        WebDriver driver = new OperaDriver(options);
        setWebDriver(driver);
        driver.quit();
    }

}

