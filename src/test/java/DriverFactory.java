import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by annayushina on 14/05/17.
 */
public class DriverFactory {
    public  enum BrowserType {
        FIREFOX,
        CHROME,
        IE,
        SAFARI
    }

    public static WebDriver getDriver(BrowserType type) {
        WebDriver driver = null;

        switch (type){
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver-v0.18.0-arm7hf.tar");
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
                driver = new ChromeDriver();
                break;

        }

        return driver;
    }
}
