package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CheckoutPage {

    WebDriver driver;

    private String expectedSubTotal;

    private final ProductPage productPage;

    @FindBy(xpath = "//*[contains(text(),'Sauce Labs Backpack')]")
    WebElement sauceLabsBackpack;

    @FindBy(xpath = "//*[contains(text(),'Sauce Labs Bike Light')]")
    WebElement sauceLabsBikeLight;

    @FindBy(id = "item_5_title_link")
    WebElement firstProductInCard;

    @FindBy(id = "item_4_title_link")
    WebElement secondProductInCard;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(css = ".summary_subtotal_label")
    WebElement subTotalValue;

    @FindBy(css = ".summary_tax_label")
    WebElement taxValue;

    @FindBy(css = ".summary_total_label")
    WebElement totalValue;

    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(xpath = "//img[@alt='Pony Express']")
    WebElement completeImage;

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement thankYouForYourOrderLabel;

    @FindBy(xpath = "//div[@class='complete-text']")
    WebElement yourOrderHasBeenDispatchedLabel;

    public CheckoutPage (WebDriver driver,ProductPage productPage){
        this.driver = driver;
        this.productPage = productPage;
        PageFactory.initElements(driver,this);
    }

    public void verifyListProductDisplayedOnCart(){
        //verify nama produk di keranjang sesuai dengan nama produk yang sudah kita save sebelumnya dengan put hashmap
        Assert.assertEquals(firstProductInCard.getText(),ProductPage.getProductName1());
        Assert.assertEquals(secondProductInCard.getText(),ProductPage.getProductName2());
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public void inputFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void inputZipPostalCode(String postalCode){
        postalCodeField.sendKeys(postalCode);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void verifySubTotal(){

        var SubTotal = productPage.subTotal(); //ambil value subTotal sebelumnya di product page untuk expected subTotal
        var expectedSubTotal = SubTotal.replace("$",""); //ambil value subTotal hanya angka saja

        var actualSubTotalLabel = subTotalValue.getText(); //variable actual subTotal

        //Bersihkan variable actual subTotal dari simbol selain angka dengan regex
        var actualSubTotal = actualSubTotalLabel.replaceAll("[^\\d.]", "");

        Assert.assertEquals(actualSubTotal,expectedSubTotal); //verify actual sub total dan expected sub total sesuai

    }

    public void verifyTotal() {

        // ambil nilai aktual dari total harga dan menghapus karakter selain angka dengan regex
        var subTotal = totalValue.getText();
        var actualSubTotalLabelString = subTotal.replaceAll("[^\\d.]", "");

        // konversi nilai aktual ke double
        double actualSubTotal = Double.parseDouble(actualSubTotalLabelString);

        // Mengambil nilai expected dan membandingkannya dengan nilai aktual
        double expectedTotalValue = expectedTotal();
        Assert.assertEquals(actualSubTotal, expectedTotalValue, 0.01);
    }

    public double expectedTotal() {

        //ambil value subTotal sebelumnya di product page untuk expected subTotal
        var expectedTotalLabel = productPage.subTotal();
        var expectedTotalLabelString = expectedTotalLabel.replace("$", "");

        // konversi itemTotal dari String ke double
        double expectedTotal = Double.parseDouble(expectedTotalLabelString);

        // ambil value tax dari taxLabel dan menghapus simbol non-digit
        var taxLabel = taxValue.getText();
        var taxLabelString = taxLabel.replaceAll("[^\\d.]", "");

        // konversi taxValue ke double
        double taxValue = Double.parseDouble(taxLabelString);

        // tambahkan expected Total dengan taxValue
        double totalValue = expectedTotal + taxValue;

        // gunakan BigDecimal untuk pembulatan hingga dua tempat desimal
        BigDecimal bd = new BigDecimal(totalValue).setScale(2, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

    public void clickFinishButton(){
        finishButton.click();
    }

    public void verifyCheckoutComplete(){
        Assert.assertTrue(checkoutComplete());
    }

    public boolean checkoutComplete(){
        completeImage.isDisplayed();
        thankYouForYourOrderLabel.isDisplayed();
        yourOrderHasBeenDispatchedLabel.isDisplayed();
        return true;
    }

}
