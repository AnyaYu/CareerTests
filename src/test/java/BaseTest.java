import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.CareerPage;
import pages.MainPage;

public class BaseTest {
    WebDriver driver;
    MainPage mainPage;
    CareerPage careerPage;

    @BeforeSuite (alwaysRun = true)
    public void setUp(){
        this.driver = DriverFactory.getDriver(DriverFactory.BrowserType.CHROME);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        careerPage = PageFactory.initElements(driver, CareerPage.class);
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
