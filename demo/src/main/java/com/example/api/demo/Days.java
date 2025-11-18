package com.example.api.demo;

import java.util.ArrayList;
import java.util.List;

// Storage class for days
public class Days {
    private List<Stock> appData;

    // Get the day list (initialize if null)
    public List<Stock> getAppData() {
        if (appData == null) {
            appData = new ArrayList<>();
        }
        return appData;
    }

    public void setAppDatappData(List<Stock> appData) {
        this.appData = appData;
    }
}
