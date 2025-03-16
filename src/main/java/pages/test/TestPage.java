package pages.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class TestPage extends BasePage {

    @AndroidFindBy(accessibility = "Beranda")
    private MobileElement berandaButton;

    @AndroidFindBy(xpath = "//*[@text='Cek Tarif']")
    private MobileElement cekTarifMenu;

    @AndroidFindBy(xpath = "//*[@text='Cek Tarif untuk Pengirimanmu']")
    private MobileElement cekTarifPengirimanLabel;

    @AndroidFindBy(id = "com.lionparcel.services.consumer:id/btnCheckTariff")
    private MobileElement cekTarifButton;

    @AndroidFindBy(id = "com.lionparcel.services.consumer:id/edtOriginAddress")
    private MobileElement asalField;

    @AndroidFindBy(id = "com.lionparcel.services.consumer:id/edtDestinationAddress")
    private MobileElement tujuanField;

    @AndroidFindBy(id = "com.lionparcel.services.consumer:id/edtRouteSearch")
    private MobileElement searchSection;

    @AndroidFindBy(id = "com.lionparcel.services.consumer:id/txtDistrictRouteName")
    private MobileElement kecamatanValueInSearch;

    @AndroidFindBy(xpath = "(//*[@resource-id=\"com.lionparcel.services.consumer:id/txtEstimatedPrice\"])[3]")
    private MobileElement biayaRegpackValue;

    @AndroidFindBy(id = "com.lionparcel.services.consumer:id/txtTotalTariffEstimation")
    private MobileElement totalBiayaValue;

    @AndroidFindBy(id = "com.lionparcel.services.consumer:id/edtTotalWeight")
    private MobileElement totalBeratField;


    public TestPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void changeTotalBerat(String berat){
        sendKeys(totalBeratField,berat);
    }

    public String getBiayaTotalValue()throws Exception {
        scrollToElement(totalBiayaValue,"up");
        return totalBiayaValue.getText();
    }

    public String getBiayaRegpackValue() throws Exception {
        scrollToElement(biayaRegpackValue,"up");
        return biayaRegpackValue.getText();
    }

    public void clickCekTarifButton(){
        click(cekTarifButton);
    }

    public void clickResultSearchSection(){
        click(kecamatanValueInSearch);
    }

    public String verifyResultSearch(){
        return kecamatanValueInSearch.getText();
    }

    public void inputSearchSection(String kecamatan){
        sendKeys(searchSection,kecamatan);
    }

    public String valueAsalFilledAndCorrect(){
        return asalField.getText();
    }

    public void clickTujuanField(){
        click(tujuanField);
    }

    public void onCekTarifPage(){
        waitForVisibility(cekTarifMenu);
        cekTarifMenu.isDisplayed();
        cekTarifPengirimanLabel.isDisplayed();
        cekTarifButton.isDisplayed();
    }

    public void clickCekTarif() throws Exception {
        click(cekTarifMenu);
    }

    public void onBerandaPage()throws InterruptedException {
        Thread.sleep(5000);
        waitForVisibility(berandaButton);
        berandaButton.isDisplayed();
    }

}
