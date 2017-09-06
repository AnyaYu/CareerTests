package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        this.url = "https://www.epam.com";

    }

    @FindBy(linkText = "SOLUTIONS")
    public WebElement solutionElement;

    @FindBy (linkText = "Product Development")
    WebElement productDevelopmentElement;
}
