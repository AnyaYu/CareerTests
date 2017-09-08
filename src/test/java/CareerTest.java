import data.CareerFilterData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

import java.util.List;

public class CareerTest extends BaseTest {

    @Test(dataProvider = "careerFilterData", dataProviderClass = CareerFilterData.class)
    public void careerTesting(String keyWord, String firstName, String lastName, String email, String country, String location, String message) {

        Assert.assertEquals(driver.getCurrentUrl(), mainPage.url);

        hover(mainPage.solutionButton);
        mainPage.productDevelopment.click();
        wait.until(ExpectedConditions.urlToBe(productDevelopmentPage.url));


        BasePage.careerButton.click();
        wait.until(ExpectedConditions.urlToBe(careerPage.url));
        log.info("Career page opened");

        BasePage.setElementText(careerPage.jobSearchKeywordField, keyWord);
        careerPage.selectLocation(location);
        careerPage.searchButton.click();
        log.info("Job filter submitted");


        List<WebElement> jobsList = driver.findElements(By.cssSelector(".search-result-item"));
        for (WebElement element: jobsList){
           if (element.getText().contains("Test Automation Engineer (back-end)")) {
               WebElement elementApply = element.findElement(By.cssSelector(".button-apply"));
               wait.until(ExpectedConditions.elementToBeClickable(elementApply));
                       elementApply.click();
               break;
           }
        }
        wait.until(ExpectedConditions.urlMatches(".*/careers/job-listings/job\\.\\d*#apply"));
        log.info("JobListening page opened");

        jobDescriptionPage.CVFormSubmit(firstName, lastName, email, country, location, message);
        log.info("CV submitted");

        Assert.assertTrue(!jobDescriptionPage.captcha.getAttribute("class").contains("form-field-error"));
        log.info("Captcha error found");


    }
}
