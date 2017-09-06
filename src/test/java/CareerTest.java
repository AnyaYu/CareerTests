import data.CareerFilterData;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CareerTest extends BaseTest {

    @Test(dataProvider = "careerFilterData", dataProviderClass = CareerFilterData.class)
    public void careerTesting (){
        mainPage.solutionElement.click();
    }
}
