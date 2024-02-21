package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainPage {
    WebDriver driver;
    WebDriverWait driverWait;
    ArrayList<Product> basket = new ArrayList<>();

    public ArrayList<Product> getBasket() {
        return basket;
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.wildberries.ru/");
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void addProductInBasket(int quantity) {
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@class='product-card__add-basket j-add-to-basket btn-main']"))));
        System.out.println("ТОВАРЫ С ГЛАВНОЙ СТРАНИЦЫ\n");
        for (int i = 0; i < quantity; i++) {
            WebElement productWeb = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[2]/div/div[2]/div/article[" + (i + 1) + "]"));
            productWeb.findElement(By.className("product-card__order-wrap")).click();
            try {
                driver.findElement(By.className("j-quick-order-size-fake")).click();
            } catch (Exception ignored) {
            }
            Product product = new Product();
            product.setName(productWeb.findElement(By.className("product-card__name")).getText().replace("/ ", ""));
            product.setPrice(Integer.parseInt(productWeb.findElement(By.tagName("ins")).getAttribute("textContent").replaceAll("[^\\d]", "")));
            basket.add(product);
            System.out.println("название: " + product.getName());
            System.out.println("цена: " + product.getPrice() + "\n");
            //сделать автовыбор размера!!
        }

    }
}
