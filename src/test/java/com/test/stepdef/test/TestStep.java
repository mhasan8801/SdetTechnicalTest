package com.test.stepdef.test;

import com.test.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.test.TestPage;

import java.io.IOException;

public class TestStep {

    private final AndroidDriver<AndroidElement> driver;


    public TestStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    @And("The user verify Total Biaya is correct with packet Regpack after update berat barang")
    public void verifyTotalBiayaWithRegpackAfterUpdate() throws Exception {
        TestPage testPage = new TestPage(driver);
        Thread.sleep(5000); //not rekomend use thread sleep
        Assert.assertEquals(testPage.getBiayaRegpackValue(),"Rp93.750"); //hardcode krn waktu tidak cukup untuk buat validasi
        Assert.assertEquals(testPage.getBiayaTotalValue(),"Rp93.750");
    }

    @And("On cek tarif page, The user change total berat barang to {string} kg")
    public void changeTotalBerat(String berat) throws Exception {
        TestPage testPage = new TestPage(driver);
        testPage.changeTotalBerat(berat);
    }

    @And("The user verify Total Biaya is correct with packet Regpack")
    public void verifyTotalBiayaWithRegpack() throws Exception {
        TestPage testPage = new TestPage(driver);
        Assert.assertEquals(testPage.getBiayaTotalValue(),testPage.getBiayaRegpackValue());
    }

    @And("On cek tarif page, The user click Cek Tarif button")
    public void clickCekTarifButton() throws Exception {
        TestPage testPage = new TestPage(driver);
        testPage.clickCekTarifButton();
    }

    @And("The user click result search section")
    public void clickResultSearchSection() throws Exception {
        TestPage testPage = new TestPage(driver);
        testPage.clickResultSearchSection();
    }

    @And("The user verify result search is {string}")
    public void verifyResultSearch(String kecamatan) throws Exception {
        TestPage testPage = new TestPage(driver);
        Assert.assertEquals(testPage.verifyResultSearch(),kecamatan);
    }

    @And("The user input {string} in search section")
    public void inputSearchSection(String kecamatan) throws Exception {
        TestPage testPage = new TestPage(driver);
        testPage.inputSearchSection(kecamatan);
    }

    @And("On cek tarif page, The user click Tujuan field")
    public void clickTujuanField() throws Exception {
        TestPage testPage = new TestPage(driver);
        testPage.clickTujuanField();
    }

    @Then("The user verify value Asal auto filled {string}")
    public void valueAsalFilledAndCorrect(String asal) throws Exception {
        TestPage testPage = new TestPage(driver);
        Assert.assertEquals(testPage.valueAsalFilledAndCorrect(),asal);
    }

    @Then("The user verify already on Cek Tarif page")
    public void onCekTarifPage() throws Exception {
        TestPage testPage = new TestPage(driver);
        testPage.onCekTarifPage();
    }

    @When("On beranda page, The user click Cek Tarif menu")
    public void clickCekTarif() throws Exception {
        TestPage testPage = new TestPage(driver);
        testPage.clickCekTarif();
    }

    @Given("The user opens the Lion Parcel apps")
    public void openApp() throws Exception {
        TestPage testPage = new TestPage(driver);
        testPage.onBerandaPage();
    }

}
