package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class HomePage {
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);
    private final WebDriver driver;
    private final By searchBar = By.xpath("/html/body/div[1]/div/div/nav/div/div[1]/form/div/label/input");

    private final By elements = By.xpath("/html/body/div[1]/div/main/div/section/section/ul/li//h3");

    public HomePage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void openPage(){
        driver.get("https://us.puma.com/us/en");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
    }

    public void search(String searchText){
        WebElement searchBar = driver.findElement(this.searchBar);
        searchBar.sendKeys(searchText);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void printAllItemInfo(){
        List<WebElement> elementsList = driver.findElements(elements);
        LOGGER.info("size = "+elementsList.size());
        for (WebElement webElement : elementsList) {
            LOGGER.info(webElement.getText());
        }
    }

    public void close() {
        driver.close();
    }

}