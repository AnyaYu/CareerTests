package data;

import org.testng.annotations.DataProvider;

public class CareerFilterData {
    @DataProvider(name = "careerFilterData")
    public static Object[][] careerFilterData(){

        return new Object[][]{
                {"Test",  "Roman", "Iovlev", "roman_iovlev@epam.com",
                        "Russian Federation", "Saint-Petersburg", "I WANT TO WORK IN EPAM!!!",
                        "Test Automation Engineer (back-end)"}
        };
    }
}
