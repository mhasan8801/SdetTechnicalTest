package com.test.stepdef.test;

import com.test.hooks.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.test.TestPage;

import java.io.IOException;

public class TestStep {

    private final AndroidDriver<AndroidElement> driver;


    public TestStep() throws IOException {
        super();
        this.driver = Hooks.driver;
    }

    @Given("User opens the apps")
    public void openApp() throws Exception {
        TestPage testPage = new TestPage(driver);
//        testPage.onHomePage();
        System.out.println("home page");
    }

    @When("User on the home page")
    public void homePage() {
        TestPage testPage = new TestPage(driver);
        System.out.println("Open apps");
    }

    @When("User on success test")
    public void success() {
        TestPage testPage = new TestPage(driver);
        System.out.println("Successed");
    }

}
