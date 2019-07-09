package com.appium.page.objects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPageObject {

    @AndroidFindBy(id="com.gojek.app.staging:id/text_promo_code")
    @iOSXCUITFindBy(accessibility = "Enter Promo Code")
    public WebElement enterPromoCode;

    @AndroidFindBy(id="com.gojek.app.staging:id/edit_text_promo_code")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public  WebElement promoCodeField;

    @AndroidFindBy(id="com.gojek.app.staging:id/promo_cta_text")
    @iOSXCUITFindBy(accessibility = "VERIFY YOUR CODE")
    public  WebElement verifyYourCodeButton;

    @AndroidFindBy(id="com.gojek.app.staging:id/promo_inline_response")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[3]")
    public WebElement applyPromoLog;
}
