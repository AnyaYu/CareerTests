package pages;

import enums.Locations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CareerPage extends BasePage {
    public CareerPage(WebDriver driver) {
        super(driver);
        this.url = "https://www.epam.com/careers";
    }

    @FindBy (css = ".job-search-input")
    public WebElement jobSearchKeywordField;

    @FindBy (css = "#select-box-location-select-container")
    public WebElement jobLocationDropDownButton;

    @FindBy (css = "#location-select")
    public WebElement locationSelect;

    @FindBy (css = ".multi-select-filter")
    public WebElement departmentSelectButton;

  /*  @FindBy (linkText = "Software Test Engineering")
    public WebElement softwareTestEngDepartment; */

    @FindBy (css = "div.career-apply-box.career-apply-box-desktop > button")
    public WebElement searchButton;

    public void selectLocation (String location){
        Select select = new Select(locationSelect);
        select.selectByVisibleText(location);
    }



}
