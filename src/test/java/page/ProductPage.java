package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;

public class ProductPage {

    WebDriver driver;

    //inisiasi variable untuk harga kedua produk
    private double price1;
    private double price2;

    @FindBy(css = "title")
    WebElement productPageTitle;

    @FindBy(xpath = "//*[contains(text(),'Sauce Labs Backpack')]")
    WebElement sauceLabsBackpack;

    @FindBy(xpath = "//*[contains(text(),'Sauce Labs Bike Light')]")
    WebElement sauceLabsBikeLight;

    @FindBy(css = ".inventory_list > div:nth-of-type(1) .inventory_item_price")
    WebElement firstPriceAfterSorted;

    @FindBy(css = ".inventory_list > div:nth-of-type(2) .inventory_item_price")
    WebElement secondPriceAfterSorted;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement sortingButton;

    @FindBy(xpath = "//option[@value='hilo']")
    WebElement highToLowPrice;

    @FindBy(id = "item_5_title_link")
    WebElement nameProduct1Sorted;

    @FindBy(id = "item_4_title_link")
    WebElement nameProduct2Sorted;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement addToCardProduct1;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCardProduct2;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cardButton;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyLoginSuccess(){
        Assert.assertEquals("https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());
        productPageTitle.isDisplayed();
        sauceLabsBackpack.isDisplayed();
        sauceLabsBikeLight.isDisplayed();
    }

    public void clickSortingButton(){
        sortingButton.click();
    }

    public void clickHighToLowPrice(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(highToLowPrice));
        highToLowPrice.click();
    }

    //Hashmap untuk simpan atau put value suatu element
    static HashMap<String,String> value = new HashMap<>();

    public void addProduct1ToCard(){
        value.put("nameProduct1",nameProduct1Sorted.getText()); //simpan value nama product 1 dengan put hashmap
        addToCardProduct1.click();
    }

    public static String getProductName1(){
        return value.get("nameProduct1"); //get value nama product 1 yang sebelumnya disimpan dengan put hashmap
    }

    public void addProduct2ToCard(){
        value.put("nameProduct2",nameProduct2Sorted.getText()); //simpan value nama product 2 dengan put hashmap
        addToCardProduct2.click();
    }

    public static String getProductName2(){
        return value.get("nameProduct2"); //get value nama product 2 yang sebelumnya disimpan dengan put hashmap
    }

    public void verifySortingHighToLow(){
        Assert.assertTrue(sortingHighToLow());
    }

    public boolean sortingHighToLow(){

        //simpan value harga produk 1 dan 2 ke variable
        var price1String = firstPriceAfterSorted.getText();
        var price2String = secondPriceAfterSorted.getText();

        //pharsing tipedata ke double dan replace '$'
        price1 = Double.parseDouble(price1String.replace("$", ""));
        price2 = Double.parseDouble(price2String.replace("$", ""));

        //verify price produk 1 lebih mahar daripada produk 2
        return price1 > price2;
    }

    public String subTotal() {
        //operasi tambah harga produk 1 dan produk 2 serta kembaliannya
        double total = price1 + price2;
        return String.format("$%.2f", total);
    }

    public void clickCardButton(){
        cardButton.click();
    }

}
