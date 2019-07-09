package com.appium.screen.flows;

import com.appium.config.CommonAppiumTest;
import com.appium.config.DeviceInterface;
import com.appium.page.objects.HomePageObject;
import com.appium.pages.Login;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

public class AndroidFlow extends CommonAppiumTest implements DeviceInterface {


    public AndroidFlow(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void login(Login loginPage, String emailId, String phoneNumber) throws IOException, InterruptedException {

        if(isAndroid()){
            loginPage.loginWithEmaildId(emailId);
//            loginPage.loginWithPhoneNumber(phoneNumber);
        }

    }

    @Override
    public void waitForHomePage(HomePageObject homePageObject) {

    }
}
