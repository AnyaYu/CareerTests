package pages;

import org.openqa.selenium.WebDriver;

public class JobListingPage extends BasePage {
    public JobListingPage(WebDriver driver) {
        super(driver);
        this.url = "https://www.epam.com/careers/job-listings?query=test&department=all&city=St-Petersburg&country=Russia";
    }
}
