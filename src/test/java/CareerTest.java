import data.CareerFilterData;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

public class CareerTest extends BaseTest {

    @Test(dataProvider = "careerFilterData", dataProviderClass = CareerFilterData.class)
    public void careerTesting(String keyWord, String firstName, String lastName, String email, String country, String city, String message, String position) throws InterruptedException {

        Assert.assertEquals(driver.getCurrentUrl(), mainPage.url);

        hover(mainPage.solutionButton);
        mainPage.productDevelopment.click();
        wait.until(ExpectedConditions.urlToBe(productDevelopmentPage.url));


        BasePage.careerButton.click();
        wait.until(ExpectedConditions.urlToBe(careerPage.url));
        log.info("Career page opened");

        BasePage.setElementText(careerPage.jobSearchKeywordField, keyWord);
        careerPage.selectLocation(country, city);
        careerPage.searchButton.click();
        log.info("Job filter submitted");


        jobListingPage.positionChoosing(position);

        wait.until(ExpectedConditions.urlMatches(".*/careers/job-listings/job\\.\\d*#apply"));
        log.info("JobListening page opened");

        jobDescriptionPage.CVFormSubmit(firstName, lastName, email, country, city, message);
        log.info("CV submitted");

        Assert.assertTrue(!jobDescriptionPage.captcha.getAttribute("class").contains("form-field-error"));
        log.info("Captcha error found");


    }
}
