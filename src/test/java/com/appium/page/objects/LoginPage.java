package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage {
    @AndroidFindBy(id = "com.gojek.app.staging:id/authui_otp_edit_text")
    public MobileElement otp;

    @AndroidFindBy(id="com.gojek.app.staging:id/btn_login")
    @iOSXCUITFindBy(id="AuthEngine-Options-LoginButton")
    public MobileElement loginBtn;

    @AndroidFindBy(id="com.gojek.app.staging:id/layout_component")
    @iOSXCUITFindBy(id="AuthEngine-CountryCodeButton")
    public MobileElement selectCountryBtn;

    @AndroidFindBy(id="com.gojek.app.staging:id/input_search")
    @iOSXCUITFindBy(id="Type country name or country code")
    public  MobileElement countryCodeSearchBox;

    @AndroidFindBy(id="com.gojek.app.staging:id/layout_country_picker_item")
    @iOSXCUITFindBy(xpath = "//*[@name=\"AuthEngine-CountriesList\"]/XCUIElementTypeCell[1]")
    public MobileElement countryPicker;

    @AndroidFindBy(id="com.gojek.app.staging:id/input_field")
    @iOSXCUITFindBy(id = "AuthEngine-Phone number")
    public MobileElement phoneNoInputBox;

    @AndroidFindBy(id="com.gojek.app.staging:id/button_continue")
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(id="AuthEngine-AccessoryContinuePressedOnLogin")
    @iOSXCUITFindBy(id = "AuthEngine-AccessoryConfirmPressedOnOTPScreen")
    public MobileElement continueBtn;

    @iOSXCUITFindBy(id = "AuthEngine-OTPTextField0")
    @AndroidFindBy(id="com.gojek.app.staging:id/authui_pin_text_first")
    public MobileElement otp1;

    @iOSXCUITFindBy(id = "AuthEngine-OTPTextField1")
    @AndroidFindBy(id="com.gojek.app.staging:id/authui_pin_text_second")
    public MobileElement otp2;

    @iOSXCUITFindBy(id = "AuthEngine-OTPTextField2")
    @AndroidFindBy(id="com.gojek.app.staging:id/authui_pin_text_third")
    public MobileElement otp3;

    @iOSXCUITFindBy(id = "AuthEngine-OTPTextField3")
    @AndroidFindBy(id="com.gojek.app.staging:id/authui_pin_text_fourth")
    public MobileElement otp4;
}
