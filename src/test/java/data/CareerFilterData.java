package data;

import enums.JobCategories;
import enums.Locations;
import org.testng.annotations.DataProvider;

public class CareerFilterData {
    @DataProvider(name = "careerFilterData")
    public static Object[][] careerFilterData(){

        return new Object[][]{
                {"Test", JobCategories.QA, Locations.SAINT_PETERSBURG}
        };
    }
}
