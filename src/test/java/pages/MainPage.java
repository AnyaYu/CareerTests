package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        this.url = "https://www.epam.com/";

    }

    @FindBy(css = "nav>ul>li:nth-child(1)>a")
    public WebElement solutionButton;

    @FindBy (css = ".submenu")
    WebElement submenu;

    @FindBy (linkText = "Product Development")
    public WebElement productDevelopment;

    public void selectSolution(String text){
        Select select = new Select(submenu);
        select.selectByVisibleText(text);
    }


}
