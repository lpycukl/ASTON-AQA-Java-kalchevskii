package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class BasketPage {
    WebDriver driver;

    WebDriverWait driverWait;
    private ArrayList<Product> basket = new ArrayList<>();
    private int totalPriceByProducts = 0;


    public int getTotalPriceByProducts() {
        return (int) Math.round(totalPriceByProducts);
    }

    public int getTotalPriceFromPage() throws InterruptedException {
        Thread.sleep(1000);
        return Integer.parseInt(driver.findElement(By.xpath("//p[contains(@class,'b-top__total line')]")).getText().replaceAll("[^\\d]", ""));
    }

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.wildberries.ru/lk/basket");
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void BasketPageFillBasket() throws InterruptedException {
        List<WebElement> elements = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div")).findElements(By.className("accordion__list-item"));
        System.out.println("ТОВАРЫ С КОРЗИНЫ\n");
        Thread.sleep(1000);

        for (WebElement element : elements) {
            Product product = new Product();
            product.setName(element.findElement(By.className("good-info__good-name")).getText());
            product.setPrice(Integer.parseInt(element.findElement(By.className("list-item__price-wallet")).getAttribute("textContent").replaceAll("[^\\d]", "")));
            int priceWithoutWBCard = Integer.parseInt(element.findElement(By.className("list-item__price-new")).getAttribute("textContent").replaceAll("[^\\d]", ""));
            totalPriceByProducts += priceWithoutWBCard;
            System.out.println("название: " + product.getName());
            System.out.println("цена: " + product.getPrice());
            System.out.println("цена без вб карты: " + priceWithoutWBCard + "\n");
            basket.add(product);

        }
    }

    public ArrayList<Product> getBasket() {
        return basket;
    }


}
