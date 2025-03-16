package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.CheckoutPage;
import page.LoginPage;
import page.ProductPage;

import java.time.Duration;

public class Checkout {

    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkout()  {

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver,productPage);

        loginPage.openLoginPage();
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        productPage.verifyLoginSuccess();
        productPage.clickSortingButton();
        productPage.clickHighToLowPrice();
        productPage.verifySortingHighToLow();
        productPage.addProduct1ToCard();
        productPage.addProduct2ToCard();
        productPage.clickCardButton();

        checkoutPage.verifyListProductDisplayedOnCart();
        checkoutPage.clickCheckoutButton();
        checkoutPage.inputFirstName("M.");
        checkoutPage.inputLastName("Hasan");
        checkoutPage.inputZipPostalCode("1234");
        checkoutPage.clickContinueButton();
        checkoutPage.verifyListProductDisplayedOnCart();
        checkoutPage.verifySubTotal();
        checkoutPage.verifyTotal();
        checkoutPage.clickFinishButton();
        checkoutPage.verifyCheckoutComplete();

    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
