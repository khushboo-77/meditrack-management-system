package com.khush.meditrack.util;

public class AppConfig {

    private static AppConfig instance; // lazy

    private final String appName;
    private final String version;

    private AppConfig() {
        this.appName = "MediTrack";
        this.version = "1.0";
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig(); // created only when needed
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }

    public String getVersion() {
        return version;
    }
}
