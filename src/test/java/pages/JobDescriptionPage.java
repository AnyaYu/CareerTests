package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JobDescriptionPage extends BasePage {
    public JobDescriptionPage(WebDriver driver) {
        super(driver);
        this.url="https://www.epam.com/careers/job-listings/job.11516#apply";
    }

    @FindBy(css = "input[ placeholder=\"First Name\"]")
    public WebElement firstNameField;

    @FindBy(css = "input[ placeholder=\"Last Name\"]")
    public WebElement lastNameField;

    @FindBy(css = "input[ placeholder=\"Email\"]")
    public WebElement emailField;

    @FindBy(css = ".city-wrapper")
    public WebElement cityField;

    @FindBy(css = ".country-wrapper")
    WebElement countrySelectButton;

    @FindBy(css = ".comment-input")
    WebElement commentField;

    @FindBy(xpath = "//*[.='Submit']")
    WebElement submit;

    @FindBy(name = "captcha")
    public WebElement captcha;

    @FindBy(css = ".options")
    WebElement countryUl;

    @FindBy(css = ".select-box-results")
    WebElement cityUl;



    public void selectCountry (String country){
        countrySelectButton.click();

      List<WebElement> listCountry = countryUl.findElements(By.cssSelector("li"));
      for (WebElement element: listCountry){
          if (element.getText().contains(country)) {
              element.click();
              break;
          }
      }

    }

    public void selectCity (String city){

        cityField.click();
        List<WebElement> listCity = cityUl.findElements(By.cssSelector("li"));
        for (WebElement element: listCity){
            if (element.getText().contains(city)) {
                element.click();
                break;
            }
        }
    }

    public void CVFormSubmit(String firstName, String lastName, String email, String country, String city, String message) throws InterruptedException {
       setElementText(firstNameField, firstName);
       setElementText(lastNameField, lastName);
       setElementText(emailField, email);
       selectCountry(country);
       selectCity(city);
       setElementText(commentField, message);
       submit.click();
    }
}
