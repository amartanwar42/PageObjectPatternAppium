package com.appium.tests;

import com.appium.config.GrowthConst;
import com.appium.manager.AppiumDriverManager;
import com.appium.pages.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyDeepLinkTest {

    @Test()
    public void successfullyEnrollThe_CarPromo_AndRedirectedTo_CarPage() throws IOException, InterruptedException {
        Login login=new Login(AppiumDriverManager.getDriver());
        login.loginToApp(GrowthConst.PHONE_NO,GrowthConst.EMAIL_ID);

        HomePage homePage =new HomePage(AppiumDriverManager.getDriver());
        homePage.tapOnAccountLink();

        AccountPage accountPage =new AccountPage(AppiumDriverManager.getDriver())
                .tapOnEnterPromoCode()
                .enterPromoCode("CAR")
                .tapOnVerifyPromoCode()
                .verifyPromoCode("Your promo is now ready to use! Use it now, shall we?");

        TransportPage transportPage=new TransportPage(AppiumDriverManager.getDriver())
                .enterDestination()
                .tapOnPickUpButton()
                .validateSerivceIsRide("GO-CAR")
                .selectPaymentType()
                .validatePromoCodeIsAutosApplied("Rp3.000 cashback");
    }

    @Test()
    public void successfullyEnrollThe_FoodPromo_AndRedirectedTo_FoodPage() throws IOException, InterruptedException {
        Login login=new Login(AppiumDriverManager.getDriver());
        login.loginToApp(GrowthConst.PHONE_NO,GrowthConst.EMAIL_ID);

        HomePage homePage =new HomePage(AppiumDriverManager.getDriver());
        homePage.tapOnAccountLink();

        AccountPage accountPage =new AccountPage(AppiumDriverManager.getDriver())
                .tapOnEnterPromoCode()
                .enterPromoCode("FOOD")
                .tapOnVerifyPromoCode()
                .verifyPromoCode("Your promo is now ready to use! Use it now, shall we?");


        FoodPage foodPage=new FoodPage(AppiumDriverManager.getDriver());
        foodPage.tapOnVoucherAppliedButton();
        foodPage.tapOnGotItButton();
        foodPage.validateVoucherApplied("Rp3k discount applied");


    }

    @Test()
    public void successfullyEnrollThePromoCodeWhichHas_HomePageDeepLink_AndRedirectedTo_HomePage() throws IOException, InterruptedException {
        Login login=new Login(AppiumDriverManager.getDriver());
        login.loginToApp(GrowthConst.PHONE_NO,GrowthConst.EMAIL_ID);

        HomePage homePage =new HomePage(AppiumDriverManager.getDriver());
        homePage.tapOnAccountLink();

        AccountPage accountPage =new AccountPage(AppiumDriverManager.getDriver())
                .tapOnEnterPromoCode()
                .enterPromoCode("HOME")
                .tapOnVerifyPromoCode()
                .verifyPromoCode("Your promo is now ready to use! Use it now, shall we?");
        homePage.validateHomePageDeepLink();
    }

    @Test()
    public void successfullyEnrollThePromoCodeWhichHas_PointsDeepLink_AndRedirectedTo_PointsPage() throws IOException, InterruptedException {
        Login login=new Login(AppiumDriverManager.getDriver());
        login.loginToApp(GrowthConst.PHONE_NO,GrowthConst.EMAIL_ID);

        HomePage homePage =new HomePage(AppiumDriverManager.getDriver());
        homePage.tapOnAccountLink();

        AccountPage accountPage =new AccountPage(AppiumDriverManager.getDriver())
                .tapOnEnterPromoCode()
                .enterPromoCode("POINTS")
                .tapOnVerifyPromoCode()
                .verifyPromoCode("Your promo is now ready to use! Use it now, shall we?");

        PointsPage pointsPage=new PointsPage(AppiumDriverManager.getDriver())
                .verifyPointsPage();
    }

    @Test()
    public void successfullyEnrollThePromoCodeWhichHas_PointsMyVoucherLink_AndRedirectedTo_MyVouchersPage() throws IOException, InterruptedException {
        Login login=new Login(AppiumDriverManager.getDriver());
        login.loginToApp(GrowthConst.PHONE_NO,GrowthConst.EMAIL_ID);

        HomePage homePage =new HomePage(AppiumDriverManager.getDriver());
        homePage.tapOnAccountLink();

        AccountPage accountPage =new AccountPage(AppiumDriverManager.getDriver())
                .tapOnEnterPromoCode()
                .enterPromoCode("MYVOUCHER")
                .tapOnVerifyPromoCode()
                .verifyPromoCode("Your promo is now ready to use! Use it now, shall we?");

        MyVoucherPage myVoucherPage=new MyVoucherPage(AppiumDriverManager.getDriver())
                .verifyMyVoucherPage();
    }




}
