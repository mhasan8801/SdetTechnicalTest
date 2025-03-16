package pages.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.base.BasePage;

public class TestPage extends BasePage {

    @AndroidFindBy(xpath = "//*[@text='LOGIN']")
    private MobileElement loginButton;

    public TestPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void onHomePage() throws Exception {
        waitForVisibility(loginButton);
        loginButton.isDisplayed();
    }

}
