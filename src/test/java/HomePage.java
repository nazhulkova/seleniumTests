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

        @FindBy (xpath = "//*[@id=\"ext-gen1054\"]/ul/li[1]/div/ul/li[1]/a")
        private WebElement userInfo;
        @FindBy(xpath = "//*[@id=\"button-1293-btnInnerEl\"]")
        private WebElement makeBookingButton;

        public void checkHomeScreen(){
            userData = userInfo.getText();
            Assert.assertEquals("Guybrush Threepwood from Addison Lee Plc", userData);
        }

}
