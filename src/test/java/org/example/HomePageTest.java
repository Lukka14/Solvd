package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class HomePageTest {
    private static final Logger LOGGER = LogManager.getLogger(HomePageTest.class);
    @Test
    public void testPage(){
        //WebDriver driver = new SafariDriver();
        HomePage homePage = new HomePage();
        homePage.openPage();
        homePage.search("Training shoes");
        homePage.printAllItemInfo();
    }

    @Test
    public void login() {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "path of driver");
//        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com/users/sign_in");
        WebElement username=driver.findElement(By.id("user_email_Login"));
        WebElement password=driver.findElement(By.id("user_password"));
        WebElement login=driver.findElement(By.name("commit"));
        username.sendKeys("abc@gmail.com");
        password.sendKeys("your_password");
        login.click();
        String actualUrl="https://live.browserstack.com/dashboard";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }


}
