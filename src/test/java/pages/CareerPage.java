package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CareerPage extends BasePage {
    public CareerPage(WebDriver driver) {
        super(driver);
        this.url = "https://www.epam.com/careers";
    }

    @FindBy (css = ".job-search-input")
    public WebElement jobSearchKeywordField;

    @FindBy (css = "#select-box-location-select-container")
    public WebElement jobLocationDropDownButton;

    @FindBy (css = "div.career-apply-box.career-apply-box-desktop > button")
    public WebElement searchButton;

    @FindBy (id="select-box-location-select-results")
    WebElement locationUl;


    public void selectLocation(String country, String city){
        jobLocationDropDownButton.click();
        List<WebElement> listLocation = locationUl.findElements(By.cssSelector("li"));
        WebElement chosenCountry = null;
        for (WebElement element: listLocation){
            if (element.getText().contains(country)) {
                if (!element.getAttribute("class").contains("dropdown-invisible-group")) {
                    element.click();
                }
                chosenCountry = element;
                break;
            }
        }
        List<WebElement> listCity = chosenCountry.findElements(By.cssSelector("li"));
        for (WebElement elementCity: listCity){
            if (elementCity.getText().contains(city)){
                elementCity.click();
                break;
            }
        }

    }
}
