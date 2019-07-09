package com.appium.config;

import com.appium.page.objects.HomePageObject;
import com.appium.pages.*;

import java.io.IOException;

public interface DeviceInterface {

    public void login(Login loginPage, String emailId, String phoneNumber) throws IOException, InterruptedException;

    public void waitForHomePage(HomePageObject homePageObject);

}
