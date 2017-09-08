import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    MainPage mainPage;
    CareerPage careerPage;
    ProductDevelopmentPage productDevelopmentPage;
    JobListingPage jobListingPage;
    JobDescriptionPage jobDescriptionPage;
    Logger log = Logger.getLogger("log");


    @BeforeSuite (alwaysRun = true)
    public void setUp(){
        this.driver = DriverFactory.getDriver(DriverFactory.BrowserType.CHROME);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);

        mainPage = PageFactory.initElements(driver, MainPage.class);
        careerPage = PageFactory.initElements(driver, CareerPage.class);
        productDevelopmentPage = PageFactory.initElements(driver, ProductDevelopmentPage.class);
        jobListingPage = PageFactory.initElements(driver, JobListingPage.class);
        jobDescriptionPage = PageFactory.initElements(driver, JobDescriptionPage.class);

    }

    public void hover(WebElement element){
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }

    @BeforeMethod(alwaysRun = true)
    public void pageLoad(){
        mainPage.loadPage();
    }

    @AfterTest(alwaysRun = true)
    public void TearDown(){
        if (driver != null){
            driver.quit();
        }

    }
}
