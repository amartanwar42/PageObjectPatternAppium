package com.appium.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ADBUtil {

    public void overRidePreferences(String authPreferenceAsJson){
        String command = String.format("adb shell am start-foreground-service -n  com.gojek.app.staging/com.gojek.instrumentation.persistence.preferences.PreferencesOverrideService --es \'overrideData\' %s", authPreferenceAsJson);
        executeCommand(command);
    }

    public void closeAppUsingADBCommand( String appPkgName) throws IOException, InterruptedException {
        String commandStopActivity = String.format("adb shell am force-stop " + appPkgName);
        executeCommand(commandStopActivity);
    }

    public void relaunchAppUsingADBCommand(String appPkgName, String homeLaunchableActivityName) throws IOException, InterruptedException {
        String commandLaunchActivity = String.format("adb shell am start " + appPkgName + "/" + homeLaunchableActivityName);
        executeCommand(commandLaunchActivity);
    }


    public void executeCommand(String strCmd) {
        String resultLine;
        String resultCmd = "";
        try {
            Process process = Runtime.getRuntime().exec(strCmd);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((resultLine = bufferedReader.readLine()) != null) {
                System.out.println(resultLine);
                if (!(resultLine.equalsIgnoreCase(""))) {
                    resultCmd = resultLine;
                }
            }
            process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(resultCmd);
    }
}
