package com.appium.page.objects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyVouchersPageObject {
    @AndroidFindBy(id = "btn_use")
    public WebElement useButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Vouchers']")
    public WebElement myVouchersTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='[Mobile-Automation][MyVoucher1]']")
    public WebElement voucherTitlte;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='[Mobile-Automation][MyVoucher1]']/../android.widget.TextView[5]")
    public WebElement voucherUseButton;

    @AndroidFindBy(id="com.gojek.app.staging:id/btn_buy_voucher")
    public WebElement voucherDetailsUsebtn;
}
