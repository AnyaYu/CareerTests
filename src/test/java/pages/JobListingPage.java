package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class JobListingPage extends BasePage {
    public JobListingPage(WebDriver driver) {
        super(driver);
        this.url = "https://www.epam.com/careers/job-listings?query=test&department=all&city=St-Petersburg&country=Russia";
    }

    public void positionChoosing(String position){
        List<WebElement> jobsList = driver.findElements(By.cssSelector(".search-result-item"));
        for (WebElement element: jobsList){
            if (element.getText().contains(position)) {
                WebElement elementApply = element.findElement(By.cssSelector(".button-apply"));
               // wait.until(ExpectedConditions.elementToBeClickable(elementApply));
                elementApply.click();
                break;
            }
        }

    }


}
