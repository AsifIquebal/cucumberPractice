package pageObjects.automationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utils.MyWrapper;

public class HomePage {
    public WebDriver driver;

    private final By searchBox = By.id("search_query_top");
    private final By searchButton = By.name("submit_search");
    // items
    // //ul[@class='product_list grid row']/li

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage enterSearchQuery(String string) {
        MyWrapper.sendKeys(driver, searchBox, string);
        return this;
    }

    public HomePage clickOnSearchInButton() {
        MyWrapper.click(driver, searchButton);
        return this;
    }

}
