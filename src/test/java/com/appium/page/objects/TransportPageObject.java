package com.appium.page.objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransportPageObject {

    @AndroidFindBy(id="com.gojek.app.staging:id/search_box")
    public WebElement destination;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Johar Baru']")
    public  WebElement location;

    @AndroidFindBy(id="com.gojek.app.staging:id/tv_service_type")
    public  WebElement rideServiceType;

    @AndroidFindBy(id="com.gojek.app.staging:id/txt_promo_short_descrption")
    public WebElement promoCode;

    @AndroidFindBy(id="com.gojek.app.staging:id/btn_select_via_map_confirm")
    public WebElement setPickupButton;

    @AndroidFindBy(id="com.gojek.app.staging:id/txt_payment_method")
    public WebElement paymentType;

//    @AndroidFindBy(id="com.gojek.app.staging:id/layout_cash_payment")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CASH']")
    public WebElement cashPayment;

}
