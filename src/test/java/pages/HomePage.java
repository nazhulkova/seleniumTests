package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;
    private String userData;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

        @FindBy (className = "info-item")
        private WebElement userInfo;

        public void checkHomeScreen(){
            userData = userInfo.getText();
            Assert.assertEquals("Guybrush Threepwood from Addison Lee Plc", userData);
        }

}
