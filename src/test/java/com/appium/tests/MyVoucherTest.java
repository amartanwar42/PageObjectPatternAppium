package com.appium.tests;

import com.appium.config.GrowthConst;
import com.appium.manager.AppiumDriverManager;
import com.appium.pages.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyVoucherTest {

    @Test()
    public void verifyUserIsAbleToTapUponVoucher() throws IOException, InterruptedException {
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
                .verifyMyVoucherPage()
                .tapOnVoucherBatch()
                .tapOnVoucherDetailsUsebtn();

        FoodPage foodPage=new FoodPage(AppiumDriverManager.getDriver())
                .tapOnGotItButton()
                .validateVoucherApplied("Rp3k discount applied");

    }

    @Test()
    public void verifyUserIsAbleToUseVoucherUsing_USEButton_UponVoucherAndVoucherIsAllocatingToUser() throws IOException, InterruptedException {
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
                .verifyMyVoucherPage()
                .tapOnUseButton();

        FoodPage foodPage=new FoodPage(AppiumDriverManager.getDriver())
                .tapOnGotItButton()
                .validateVoucherApplied("Rp3k discount applied");

    }
}
