package pageObjects.applicationPages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import pageObjects.SharedClass;
import pageObjects.applicationPages.HomePage;
import pageObjects.applicationPages.LoginPage;
import utils.MyWrapper;

public class BaseClass {

    SharedClass sharedClass;
    WebDriver driver;

    public BaseClass(){
        sharedClass = new SharedClass();
        driver = sharedClass.getDriver();
    }

    //@BeforeClass
    //@Parameters("browser")
    public void launchBrowser(@Optional("Chrome") String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            //System.setProperty("webdriver.chrome.driver", "Selenium\\parentResource\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            //options.setAcceptInsecureCerts(true);
            //options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            //disable automation info bar
            options.addArguments("disable-infobars");
            // Start in Maximized mode
            options.addArguments("--start-maximized");
            /*Headless on Windows, Check periodically for any modification*/
            //options.addArguments("--headless","--disable-gpu");
            //Exception exception = new Exception()
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    // Launch the Application
    public HomePage LaunchApplication(){
        driver.get("http://automationpractice.com");
        return new HomePage(driver);
    }

    // Sign In Link
    By signInLink = By.xpath("//a[normalize-space()='Sign in']");
    public LoginPage clickOnSignInLink(){
        MyWrapper.click(driver, signInLink);
        return new LoginPage(driver);
    }

    // Sign Out link
    private By signOut = By.xpath("//div/a[normalize-space()='Sign out']");
    public void clickOnSignOutLink(){
        MyWrapper.click(driver, signOut);
    }

    // Menu-Sub Menu Navigation
    // Menu
    public By WomenMenu = By.xpath("//a[@title='Women']");
    By DressesMenu = By.xpath("//a[@title='Dresses']");
    By TShirtsMenu = By.xpath("//a[@title='T-shirts']");
    By Women_CasualDress = By.xpath("//a[@title='Women']/..//a[@title='Casual Dresses']");
    public By Women_EveningDress = By.xpath("//a[@title='Women']/..//a[@title='Evening Dresses']");
    By Women_SummerDresses = By.xpath("//a[@title='Women']/..//a[@title='Summer Dresses']");

    public void moveMouse(By by) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
        Thread.sleep(2000);
    }

    public void openWomenEveningDressMenu() {
        if(driver==null){
            System.out.println("driver is null");
        }
        else {
            Actions actions = new Actions(driver);
            actions
                    .moveToElement(driver.findElement(WomenMenu))
                    .pause(2000)
                    .moveToElement(driver.findElement(Women_EveningDress))
                    .pause(2000)
                    .build()
                    .perform();
            MyWrapper.click(driver,Women_EveningDress);
        }
    }

    // Get Page Title
    public String getPageTitle(){
        return driver.getTitle();
    }

    //@AfterClass
    public void tearDown(){
        driver.quit();
    }

}


