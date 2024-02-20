package org.example;


import jdk.jfr.Timespan;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    static WebElement pay;
    static WebDriver driver;

    static WebDriverWait wait;

    @BeforeAll
    public static void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        WebElement cookie = driver.findElement(By.id("cookie-agree"));
        cookie.click();
        pay = driver.findElement(By.className("pay"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

   /* @Test
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

    } */

    @Test
    void testCorrectPlaceHoldersUslugiSvyazi() throws InterruptedException {
        pay.findElement(By.className("select__header")).click();
        pay.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p")).click();
        assertEquals("Номер телефона", pay.findElement(By.className("phone")).getAttribute("placeholder"));
        assertEquals("Сумма", pay.findElement(By.className("total_rub")).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", pay.findElement(By.className("email")).getAttribute("placeholder"));
    }

    @Test
    void testCorrectPlaceHoldersDomashniiInternet() {
        pay.findElement(By.className("select__header")).click();
        pay.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p")).click();
        assertEquals("Номер телефона", pay.findElement(By.className("phone")).getAttribute("placeholder"));
        assertEquals("Сумма", pay.findElement(By.className("total_rub")).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", pay.findElement(By.className("email")).getAttribute("placeholder"));

    }

    @Test
    void testCorrectPlaceHoldersRassrochka() {
        pay.findElement(By.className("select__header")).click();
        pay.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p")).click();
        assertEquals("Номер счета на 44", pay.findElement(By.id("score-instalment")).getAttribute("placeholder"));
        assertEquals("Сумма", pay.findElement(By.className("total_rub")).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", pay.findElement(By.className("email")).getAttribute("placeholder"));
    }

    @Test
    void testCorrectPlaceHoldersZadolzennost() {
        pay.findElement(By.className("select__header")).click();
        pay.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p")).click();
        assertEquals("Номер счета на 2073", pay.findElement(By.id("score-arrears")).getAttribute("placeholder"));
        assertEquals("Сумма", pay.findElement(By.className("total_rub")).getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", pay.findElement(By.className("email")).getAttribute("placeholder"));
    }

    @Test
    void testContinueButton() {
        pay.findElement(By.className("select__header")).click();
        pay.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p")).click();
        pay.findElement(By.className("phone")).sendKeys("297777777");
        pay.findElement(By.className("total_rub")).sendKeys("123");
        pay.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(1);
        WebElement bePaid = driver.findElement(By.className("app-wrapper"));
        assertEquals(" 123.00 BYN ", bePaid.findElement(By.className("header__payment-amount")).getAttribute("textContent"));
        assertEquals(" Оплатить  123.00 BYN ", bePaid.findElement(By.cssSelector("body > app-root > div > div > app-payment-container > section > app-card-page > div > div.card-page__card > button")).getAttribute("textContent"));
        assertEquals(" Оплата: Услуги связи\n" + "Номер:375297777777 ", bePaid.findElement(By.className("header__payment-info")).getAttribute("textContent"));
        assertEquals("Номер карты", bePaid.findElement(By.cssSelector("body > app-root > div > div > app-payment-container > section > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c53-0 > div:nth-child(1) > app-input > div > div > div.content.ng-tns-c47-1 > label")).getAttribute("textContent"));
        assertEquals("Срок действия", bePaid.findElement(By.cssSelector("body > app-root > div > div > app-payment-container > section > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c53-0 > div:nth-child(2) > div.expires-input.ng-tns-c53-0.ng-star-inserted > app-input > div > div > div.content.ng-tns-c47-4 > label")).getAttribute("textContent"));
        assertEquals("CVC", bePaid.findElement(By.cssSelector("body > app-root > div > div > app-payment-container > section > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c53-0 > div:nth-child(2) > div.cvc-input.ng-tns-c53-0.ng-star-inserted > app-input > div > div > div.content.ng-tns-c47-5 > label")).getAttribute("textContent"));
        assertEquals("Имя держателя (как на карте)", bePaid.findElement(By.cssSelector("body > app-root > div > div > app-payment-container > section > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c53-0 > div:nth-child(3) > app-input > div > div > div.content.ng-tns-c47-3 > label")).getAttribute("textContent"));
        List<WebElement> elements = bePaid.findElement(By.cssSelector("body > app-root > div > div > app-payment-container > section > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c53-0 > div:nth-child(1) > app-input > div > div > div.icons-container.ng-tns-c47-1 > div > div")).findElements(By.tagName("img"));
        assertEquals(5, elements.size());
    }


}