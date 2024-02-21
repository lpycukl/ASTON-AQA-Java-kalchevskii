package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Tests {
    static AndroidDriver driver;

    @Before
    public void init() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("Pixel 7", "");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("инициализация произошла");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test() {
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Calculator\"]\n")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"1\"]\n")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"plus\"]\n")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"3\"]\n")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"equals\"]\n")).click();
        Assert.assertEquals(Integer.parseInt(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.calculator:id/result_final\"]")).getText()), 4);
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"multiply\"]\n")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"2\"]\n")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"equals\"]\n")).click();
        Assert.assertEquals(Integer.parseInt(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.calculator:id/result_final\"]")).getText()), 8);
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"divide\"]\n")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"4\"]\n")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"equals\"]\n")).click();
        Assert.assertEquals(Integer.parseInt(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.calculator:id/result_final\"]")).getText()), 2);
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"minus\"]\n")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"0\"]\n")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"equals\"]\n")).click();
        Assert.assertEquals(Integer.parseInt(driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.calculator:id/result_final\"]")).getText()), 2);

    }
}
