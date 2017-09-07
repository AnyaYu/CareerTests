package pages;

import org.openqa.selenium.WebDriver;

public class ProductDevelopmentPage extends BasePage {
    public ProductDevelopmentPage(WebDriver driver) {
        super(driver);
        this.url = "https://www.epam.com/solutions/core-engineering/product-development";
    }
}
