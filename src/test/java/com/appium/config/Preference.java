package com.appium.config;

import java.util.ArrayList;

public class Preference {
    private String preferenceName;

    private ArrayList<Pair> overrides;

    private Boolean clear;

    public Preference(String preferenceName, ArrayList<Pair> overrides, Boolean clear) {
        this.preferenceName = preferenceName;
        this.overrides = overrides;
        this.clear = clear;
    }

    public String getPreferenceName() {
        return preferenceName;
    }

    public ArrayList<Pair> getOverrides() {
        return overrides;
    }

    public Boolean getClear() {
        return clear;
    }

    public static class Pair {
        public Pair(String key, String value, String type) {
            this.key = key;
            this.value = value;
            this.type = type;
        }

        String key;
        String value;
        String type;

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public String getType() {
            return type;
        }
    }
}
