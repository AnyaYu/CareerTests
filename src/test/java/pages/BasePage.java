package pages;

import com.sun.webkit.WebPage;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    public String url;
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".tile-menu>li>a")
    public static WebElement headerMenu;

   @FindBy(css = "nav > ul > li:nth-child(5) > a")
   public static WebElement careerButton;


    public void loadPage(){
        driver.manage().deleteAllCookies();
        driver.manage().window().setSize(new Dimension(1379, 881));
        driver.get(url);
    }

    public void getElement(WebElement element) {
        element.click();
    }

    public static void setElementText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }


}
