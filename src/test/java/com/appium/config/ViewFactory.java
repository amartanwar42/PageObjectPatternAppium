package com.appium.config;

import com.appium.screen.flows.AndroidFlow;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ViewFactory extends CommonAppiumTest {

    private AndroidFlow androidFlow;

    public ViewFactory(AppiumDriver<MobileElement> driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public DeviceInterface getMobilePlatform(String platform) {
        if (platform == null) {
            return null;
        }
        if (platform.equalsIgnoreCase("Android")) {
            if (androidFlow == null) {
                androidFlow =new AndroidFlow(driver);
            }
            return androidFlow;
        }

        return null;

    }

}
