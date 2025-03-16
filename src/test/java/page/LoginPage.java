package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//*[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")
    WebElement errorMessageLoginFailed;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openLoginPage(){
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username){
        usernameField.sendKeys(username);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void verifyLoginFailed(){
        var errorMessage = errorMessageLoginFailed.getText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",errorMessage);
    }

}
