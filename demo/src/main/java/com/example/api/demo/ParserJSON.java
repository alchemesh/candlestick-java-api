package com.example.api.demo;

public class ParserJSON {
    private String eventString;

    public ParserJSON() {}
    public ParserJSON(String eventString) {
        this.eventString = eventString;
    }

    public void setEventString(String eventString) {
        this.eventString = eventString;
    }

    public String getEventString() {
        return this.eventString;
    }
}
