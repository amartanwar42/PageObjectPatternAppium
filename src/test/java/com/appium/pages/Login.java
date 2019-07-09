package com.appium.pages;

import clients.customerOwner.CustomerOwnerClient;
import com.appium.config.*;
import com.appium.page.objects.LoginPage;
import com.appium.page.objects.Otp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import restidioms.serviceEndpoints.platform.verifyLogin.verifyLoginV3.VerifyLoginV3Response;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Login extends CommonAppiumTest {

    private LoginPage loginScreen;
    public ViewFactory viewFactory = new ViewFactory(driver);
    public DeviceInterface runnerInfo;

    public Login(AppiumDriver driver){

        super(driver);
        loginScreen=new LoginPage();
        PageFactory.initElements(new AppiumFieldDecorator(driver) ,loginScreen);
        runnerInfo = viewFactory.getMobilePlatform(driver.getPlatformName());
    }

    public HomePage loginWithPhoneNumber(String phoneNo){
//        if (isAndroid())
//            handleAlertIfPresent();
        loginScreen.loginBtn.click();
//        if (!code.equalsIgnoreCase("+62")) {
        waitForElementToBeClickable(loginScreen.selectCountryBtn).click();
        waitForElementToBeClickable(loginScreen.countryCodeSearchBox).sendKeys("India");

        loginScreen.countryPicker.click();
        //}
        loginScreen.phoneNoInputBox.sendKeys(phoneNo);
        loginScreen.continueBtn.click();
        if (driver.getPlatformName().equalsIgnoreCase("Android"))
            waitForElementToBeClickable(loginScreen.otp).sendKeys(getOTP(phoneNo));
        else {
            String otpNo=getOTP(phoneNo);
            char[] otpchar=otpNo.toCharArray();
            waitForElementToBeClickable(loginScreen.otp1).sendKeys(Character.toString(otpchar[0]));
            waitForElementToBeClickable(loginScreen.otp2).sendKeys(Character.toString(otpchar[1]));
            waitForElementToBeClickable(loginScreen.otp3).sendKeys(Character.toString(otpchar[2]));
            waitForElementToBeClickable(loginScreen.otp4).sendKeys(Character.toString(otpchar[3]));
        }

        loginScreen.continueBtn.click();
        return new HomePage(driver);
    }
    private String getOTP(String phoneNo){

        String url="http://10.120.4.21:9000/otp?phone="+phoneNo;
        Response response=given().contentType(ContentType.JSON)
                .header("clientid","red_robin")
                .header("passkey","robin1234")
                .get(url);
        Otp otpresp=response.as(Otp.class);
        List<Otp.Data> otpList=otpresp.getData();
        return otpList.get(0).getOtp();
    }
    public HomePage loginWithEmaildId(String consumerEmail){
        if (isAndroid())
//            handleAlertIfPresent();
        {
            Reporter.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Login to app started",true);

            ADBUtil adbUtil = new ADBUtil();

            VerifyLoginV3Response verifyTokenV3Response = new CustomerOwnerClient().loginV3(consumerEmail, false);
            String authPreferenceAsJson = new AuthPreferences().getAuthPreferenceAsJson(verifyTokenV3Response);
            adbUtil.overRidePreferences(authPreferenceAsJson);
            adbUtil.executeCommand("adb shell am startservice -n  com.gojek.app.staging/com.gojek.instrumentation.persistence.preferences.PreferencesOverrideService --es 'overrideData' \"[{'pref_name':'gobillsprefs','overrides':[{'key':'reorder_on_boarding_shown','value':'true','type':'bool'}],'clear':false}]\"");
            try {
                adbUtil.closeAppUsingADBCommand("com.gojek.app.staging");
                adbUtil.relaunchAppUsingADBCommand("com.gojek.app.staging", "com.gojek.app.home.HomeActivity");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new HomePage(driver);

    }

    public HomePage loginToApp(String phoneNumber, String emailId ) throws IOException, InterruptedException {

//        runnerInfo.login(this,emailId,phoneNumber);
        runnerInfo.login(this,emailId,phoneNumber);
        return new HomePage(driver);
    }
}
