package pages;

import enums.HeaderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareerPage extends BasePage {
    public CareerPage(WebDriver driver) {
        super(driver);
        this.url = "https://www.epam.com/careers";
    }


}
