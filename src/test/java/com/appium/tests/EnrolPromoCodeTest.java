package com.appium.tests;

import com.appium.config.GrowthConst;
import com.appium.manager.AppiumDriverManager;
import com.appium.pages.AccountPage;
import com.appium.pages.HomePage;
import com.appium.pages.Login;
import com.appium.pages.TransportPage;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class EnrolPromoCodeTest {

    @Test ()
    public void invalidPromoCodeTest() throws Exception {

        Login login=new Login(AppiumDriverManager.getDriver());
        Reporter.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Made Login call",true);
        login.loginToApp(GrowthConst.PHONE_NO,GrowthConst.EMAIL_ID);

        HomePage homePage =new HomePage(AppiumDriverManager.getDriver());
        homePage.tapOnAccountLink();

        AccountPage accountPage =new AccountPage(AppiumDriverManager.getDriver())
                .tapOnEnterPromoCode()
                .enterPromoCode("invalid")
                .tapOnVerifyPromoCode()
                .verifyPromoCode("Seems like this promo code is fully redeemed or invalid.");
    }

    @Test ()
    public void validPromoCodeTest() throws Exception {

        Login login=new Login(AppiumDriverManager.getDriver());
        login.loginToApp(GrowthConst.PHONE_NO,GrowthConst.EMAIL_ID);

        HomePage homePage =new HomePage(AppiumDriverManager.getDriver());
        homePage.tapOnAccountLink();

        AccountPage accountPage =new AccountPage(AppiumDriverManager.getDriver())
                .tapOnEnterPromoCode()
                .enterPromoCode("RIDE")
                .tapOnVerifyPromoCode()
                .verifyPromoCode("Your promo is now ready to use! Use it now, shall we?");

        TransportPage transportPage=new TransportPage(AppiumDriverManager.getDriver())
                .enterDestination()
                .tapOnPickUpButton()
                .validateSerivceIsRide("GO-RIDE")
                .selectPaymentType()
                .validatePromoCodeIsAutosApplied("Rp3.000 discount");

    }


}
