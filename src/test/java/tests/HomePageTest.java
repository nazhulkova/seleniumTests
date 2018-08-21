package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;


import java.util.concurrent.TimeUnit;

public class HomePageTest {


    static WebDriver driver;
    private HomePage homePage;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "//Users//natalyazhulkova//IdeaProjects//seleniumwebportal//drivers//chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://192.0.2.28/web-portal/login");
        homePage = new HomePage(driver);
        }

    @Test






    @AfterTest
    public void stopChrome(){
        driver.quit();
    }
}
