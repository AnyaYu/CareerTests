import data.CareerFilterData;

import enums.JobCategories;
import enums.Locations;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

public class CareerTest extends BaseTest {

    @Test (dataProvider = "careerFilterData", dataProviderClass = CareerFilterData.class)
    public void careerTesting (String keyWord, String location) throws InterruptedException {

        Assert.assertEquals(driver.getCurrentUrl(), mainPage.url);

        hover(mainPage.solutionButton);
        mainPage.productDevelopment.click();
        wait.until(ExpectedConditions.urlToBe(productDevelopmentPage.url));

        BasePage.careerButton.click();
        wait.until(ExpectedConditions.urlToBe(careerPage.url));

        BasePage.setElementText(careerPage.jobSearchKeywordField, keyWord);


        careerPage.jobLocationDropDownButton.click();
        careerPage.selectLocation(location);


        //careerPage.departmentSelectButton.click();
      //  careerPage.softwareTestEngDepartment.click();
    //  driver.findElements(By.cssSelector(".blue-checkbox-label")).get(11).click();

//        driver.findElement(By.cssSelector("input[data-value = 'Software Test Engineering']")).click();

        careerPage.searchButton.click();

        Thread.sleep(5000);

    }
}
