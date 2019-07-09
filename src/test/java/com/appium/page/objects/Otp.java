package com.appium.page.objects;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class Otp {
    private Error error;
    private List<Data> data;

    @Getter
    @Setter
    public static class Data{
        private String otp_token;
        private String otp_expires_at;
        private String otp;
        private String phone;

    }
    @Getter @Setter
    public static class Error{

    }
}
