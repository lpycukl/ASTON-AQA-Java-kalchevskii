package org.example;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    static WebElement pay;
    static WebDriver driver;

    @BeforeAll
    public static void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        WebElement cookie = driver.findElement(By.id("cookie-agree"));
        cookie.click();
        pay = driver.findElement(By.className("pay"));
    }

    @Test
    void testPayName() {
        assertEquals(pay.findElement(By.tagName("h2")).getText(), "Онлайн пополнение\n" + "без комиссии");
    }

    @Test
    void testPartnersIconsVisible() {
        List<WebElement> elements = pay.findElement(By.className("pay__partners")).findElements(By.tagName("img"));
        for (WebElement element : elements
        ) {
            assertTrue(element.isDisplayed());
        }
    }

    @Test
    void testPodrobneeOserviseisWork() {
        assertTrue(pay.findElement(By.linkText("Подробнее о сервисе")).isEnabled());
    }

    @Test
    void testContinueButtom() {
        assertEquals(pay.findElement(By.className("pay__form")).findElement(By.className("select__now")).getText(), "Услуги связи");
        pay.findElement(By.className("phone")).sendKeys("297777777");
        pay.findElement(By.className("total_rub")).sendKeys("123");
        assertTrue(pay.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).isEnabled());

    }
}