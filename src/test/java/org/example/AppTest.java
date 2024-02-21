package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class AppTest {

    static final int QUANTITY_PRODUCTS = 3;
    static MainPage mainPage;
    static BasketPage basketPage;
    static WebDriver driver;

    @BeforeTest
    public static void init() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        mainPage.addProductInBasket(QUANTITY_PRODUCTS);
        basketPage = new BasketPage(driver);
        basketPage.BasketPageFillBasket();
    }

    @Test
    void checkItemsAddToBucketCorrect() {
        for (int i = 0; i < QUANTITY_PRODUCTS; i++) {
            assertEquals(mainPage.getBasket().get(i), basketPage.getBasket().get(QUANTITY_PRODUCTS - 1 - i));
        }
    }

    @Test
    void checkTotalPrice() throws InterruptedException {
        assertEquals(basketPage.getTotalPriceByProducts(), basketPage.getTotalPriceFromPage());
    }

}