package com.appium.page.objects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PointsPageObject {
    @AndroidFindBy(id="com.gojek.app.staging:id/txtScore")
    public WebElement points;
}
