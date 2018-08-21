import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WelcomePageTest {
        static WebDriver driver;
        private WelcomePage welcomePage;
        private HomePage homePage;


        @BeforeMethod
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "//Users//natalyazhulkova//IdeaProjects//seleniumwebportal//drivers//chromedriver");
            driver = new ChromeDriver(); // создаем новый драйвер
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://192.0.2.28/web-portal/login");
            homePage = new HomePage(driver);iu
            welcomePage = new WelcomePage(driver);


        }

        @Test
        public void logInWithEmptyData() {
            welcomePage.clickLogInButton();
            welcomePage.checkOccurredErrorMessage(); // проверить возникшее сообщение об ошибке
        }
        @Test
        public void logInWithIncorectData(){
            welcomePage.logInWithIncorrectDate("123", "test@test.com", "qwer");
            welcomePage.checkOccurredErrorMessage();
        }

        @Test
        public void logInSuccessful(){
         welcomePage.logInSuccessful("43003186", "mighty@pirate.com", "secretpassword");
         homePage.checkHomeScreen();
          }

        @AfterTest
        public void stopChrome(){
            driver.quit();
        }



    }

