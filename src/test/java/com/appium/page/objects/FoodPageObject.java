package com.appium.page.objects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FoodPageObject {

    @AndroidFindBy(id="com.gojek.app.staging:id/btn_positive")
    public WebElement voucherAppliedButton;

    @AndroidFindBy(id="com.gojek.app.staging:id/btnDone")
    public  WebElement gotItButton;

    @AndroidFindBy(id="com.gojek.app.staging:id/txtTitle")
    public  WebElement voucherApplied;
}
