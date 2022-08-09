package com.clickup.properties;

import java.util.ResourceBundle;

public class ClickupProperties {

    private static final String TOKEN = "token";
    private static final String TEAM_ID = "team.id";

    public static String getToken() {
        return getProperty(TOKEN);
    }

    public static String getTeamId() {
        return getProperty(TEAM_ID);
    }

    private static String getProperty(String key) {
        return ResourceBundle.getBundle("clickup").getString(key);
    }
}
