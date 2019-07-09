package com.appium.pages;


import clients.growth.VoucherClient;
import com.appium.config.CommonAppiumTest;
import com.appium.config.GrowthConst;
import com.appium.page.objects.AccountPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountPage extends CommonAppiumTest {

    private AccountPageObject accountPageObject;

    public AccountPage(AppiumDriver driver){
        super(driver);
        accountPageObject =new AccountPageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver), accountPageObject);
    }

    public AccountPage tapOnEnterPromoCode(){
        waitForElementToBeClickable(accountPageObject.enterPromoCode).click();
        return this;
    }

    public AccountPage enterPromoCode(String promoCode) throws InterruptedException {

        String prCode = "INVALID";
        switch (promoCode){
            case "RIDE":
                VoucherClient voucherClient=new VoucherClient(GrowthConst.RIDE_VOUCHER_BATCH,"");
                prCode=voucherClient.createUniquePromoCode(GrowthConst.RIDE_SERVICE_TYPE,GrowthConst.RIDE_DEEPLINK);
                break;

            case "CAR":
                VoucherClient voucherClient1=new VoucherClient(GrowthConst.CAR_VOUCHER_BATCH,"");
                prCode=voucherClient1.createUniquePromoCode(GrowthConst.CAR_SERVICE_TYPE,GrowthConst.CAR_DEEPLINK);
                break;

            case "FOOD":
                VoucherClient voucherClient2=new VoucherClient(GrowthConst.FOOD_VOUCHER_BATCH,"");
                prCode=voucherClient2.createUniquePromoCode(GrowthConst.FOOD_SERVICE_TYPE,GrowthConst.FOOD_DEEPLINK);
                break;

            case "MYVOUCHER":
                VoucherClient voucherClient3=new VoucherClient(GrowthConst.MYVOUCHER_VOUCHER_BATCH,"");
                prCode=voucherClient3.createUniquePromoCode(GrowthConst.RIDE_SERVICE_TYPE,GrowthConst.MYVOUCHER_DEEPLINK);
                break;

            case "HOME":
                VoucherClient voucherClient4=new VoucherClient(GrowthConst.HOME_VOUCHER_BATCH,"");
                prCode=voucherClient4.createUniquePromoCode(GrowthConst.RIDE_SERVICE_TYPE,GrowthConst.HOME_DEEPLINK);
                break;


            case "POINTS":
                VoucherClient voucherClient5=new VoucherClient(GrowthConst.POINTS_VOUCHER_BATCH,"");
                prCode=voucherClient5.createUniquePromoCode(GrowthConst.RIDE_SERVICE_TYPE,GrowthConst.POINTS_DEEPLINK);
                break;

        }
        waitForElementToBeClickable(accountPageObject.promoCodeField).sendKeys(prCode);
        return this;
    }

    public AccountPage tapOnVerifyPromoCode(){
        waitForElementToBeClickable(accountPageObject.verifyYourCodeButton).click();
        return this;
    }

    public AccountPage verifyPromoCode(String msg) throws InterruptedException {
        Thread.sleep(3000);
        waitForElementToBeVisible(accountPageObject.applyPromoLog);
        Assert.assertEquals(accountPageObject.applyPromoLog.getText(),msg);
        return this;

    }
}
