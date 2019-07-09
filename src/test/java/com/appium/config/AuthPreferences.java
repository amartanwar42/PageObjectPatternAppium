package com.appium.config;


import restidioms.serviceEndpoints.platform.verifyLogin.verifyLoginV3.VerifyLoginV3Response;

import java.util.ArrayList;

public class AuthPreferences {
    public String getAuthPreferenceAsJson(VerifyLoginV3Response loginResponse) {
        ArrayList<Preference.Pair> overrides = new ArrayList<>();
        extractLoginResponseAndFillOverrides(loginResponse, overrides);
        overrides.add(new Preference.Pair("locale", "en", "string"));
        Preference authPreferences = new Preference("AuthPreferences", overrides, false);
        ArrayList<Preference> list = new ArrayList<>();
        list.add(authPreferences);

        return convertToJson(list);
    }



    private void extractLoginResponseAndFillOverrides(VerifyLoginV3Response loginResponse, ArrayList<Preference.Pair> overrides) {
        overrides.add(new Preference.Pair("chatId", loginResponse.getData().getChat_id(), "string"));
        overrides.add(new Preference.Pair("accessToken", loginResponse.getData().getAccess_token(), "string"));
        overrides.add(new Preference.Pair("chatToken", loginResponse.getData().getChat_token(), "string"));
        overrides.add(new Preference.Pair("phone", loginResponse.getData().getPhone_number(), "string"));
        overrides.add(new Preference.Pair("name", loginResponse.getData().getName(), "string"));
        overrides.add(new Preference.Pair("id", loginResponse.getData().getCustomer_id(), "string"));
        overrides.add(new Preference.Pair("email", loginResponse.getData().getEmail_address(), "string"));
        overrides.add(new Preference.Pair("refreshToken", loginResponse.getData().getRefresh_token(), "string"));
    }

    private String convertToJson(ArrayList<Preference> list) {
        //Preference authPreferences = new Preference("AuthPreferences", overrides, false);
        //ArrayList<Preference> list = new ArrayList<>();
        //list.add(authPreferences);

        return new JsonAdbParser(list).toJson();
    }
}
