package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WelcomePage {
    private WebDriver driver;
    private String error;


    public WelcomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

@FindBy (className = "errorMessage")
private WebElement errorText;
@FindBy(className= "corporate")
private WebElement businessLogInButton;
@FindBy(className = "personal")
private WebElement privateLogInButton;
@FindBy(id = "account")
private WebElement accountNumberField;
@FindBy(id = "username")
private WebElement emailField;
@FindBy(name = "//*[@id=\"wrap\"]/div[2]/div/div[2]/div/div/form/div[6]/div[2]/span[1]/a")
private WebElement registerButton;
@FindBy(xpath = "//*[@id=\"password\"]")
private WebElement passwordField;
@FindBy(xpath = "//*[@id=\"wrap\"]/div[2]/div/div[2]/div/div/form/div[6]/div[2]/span[2]/span/em[2]/button")
private WebElement logInButton;



public void clickLogInButton(){
        logInButton.click();

}

public void checkOccurredErrorMessage() {
    error = errorText.getText();
    Assert.assertEquals("Invalid account number, email or password", error);
}

public void typeAccNo(String account){
    accountNumberField.sendKeys(account);
}

public void typeEmail(String email){
    emailField.sendKeys(email);
}

public void typePassword(String password){
    passwordField.sendKeys(password);
}

public WelcomePage logInWithIncorrectDate(String account, String email, String password){
    this.typeAccNo(account);
    this.typeEmail(email);
    this.typePassword(password);
    logInButton.click();
    return new WelcomePage(driver);
}

public HomePage logInSuccessful(String account, String email, String password){
    this.typeAccNo(account);
    this.typeEmail(email);
    this.typePassword(password);
    logInButton.click();
    return new HomePage(driver);
}



}
