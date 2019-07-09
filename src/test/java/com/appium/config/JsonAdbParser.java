package com.appium.config;

import java.util.ArrayList;

public class JsonAdbParser {


        private ArrayList<Preference> preferences;

        public JsonAdbParser(ArrayList<Preference> preferences) {
            this.preferences = preferences;
        }

        /**
         * adb shell am start-foreground-service -n  com.gojek.app.staging/com.gojek.instrumentation.persistence.preferences.PreferencesOverrideService --es 'overrideData' "[{\'pref_name\':\'location_prefs\'\,\'overrides\':[{\'key\':\'last_location\'\,\'type\':\'string\'\,\'value\':\'{\"accuracy\":1.3,\"latitude\":1.11,\"longitude\":0.9}\'}\,{\'key\':\'override\'\,\'type\':\'bool\'\,\'value\':\'true\'}]\,\'clear\':false}]"
         */

        public String toJson() {
            StringBuffer output = new StringBuffer();
            output.append("\"[");
            for (Preference pref : preferences) {
                output.append("{\'").append("pref_name").append("\'").append(":");
                output.append("\'").append(pref.getPreferenceName()).append("\'").append(",");
                output.append("\'").append("overrides").append("\'").append(":")
                        .append("[");
                for (Preference.Pair item : pref.getOverrides()) {
                    output.append("{");
                    output.append("\'").append("key").append("\'").append(":");
                    output.append("\'").append(item.getKey()).append("\'").append(",");
                    output.append("\'").append("type").append("\'").append(":");
                    output.append("\'").append(item.getType()).append("\'").append(",");
                    output.append("\'").append("value").append("\'").append(":");
                    //Incase value contains escaped json, replace the quotes with multiple escaped characters
                    String valueWithoutDoubleQuotes = item.getValue().replace("\"", "\\\"");
                    output.append("\'").append(valueWithoutDoubleQuotes).append("\'");
                    output.append("},");
                }
                if (output.lastIndexOf(",") == output.length() - 1) {
                    output.deleteCharAt(output.lastIndexOf(","));

                }
                output.append("]").append(",");
                output.append("\'").append("clear").append("\'").append(":").append(pref.getClear());
                output.append("},");
            }
            if (output.lastIndexOf(",") == output.length() - 1) {
                output.deleteCharAt(output.lastIndexOf(","));

            }
            output.append("]\"");
            return output.toString();
        }
}
