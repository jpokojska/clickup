package com.clickup.properties;

import java.util.ResourceBundle;

public class ClickupProperties {

    private static final String TOKEN = "token";
    private static final String TEAM_ID = "team.id";

    public static String getToken() {
        if (getProperty(TOKEN).isEmpty() || getProperty(TOKEN).startsWith("TOKEN")) {
            return System.getProperty(TOKEN);
        } else {
            return getProperty(TOKEN);
        }
    }

    public static String getTeamId() {
        if (getProperty(TEAM_ID).isEmpty() || getProperty(TEAM_ID).startsWith("TEAM")) {
            return System.getProperty(TEAM_ID);
        } else {
            return getProperty(TEAM_ID);
        }
    }

    private static String getProperty(String key) {
        return ResourceBundle.getBundle("clickup").getString(key);
    }
}
