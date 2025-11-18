package com.example.api.demo;

public class Event {
    private String eventID;
    private String ticker;
    private String timestamp;

    public Event() {}
    public Event(String eventID, String ticker, String timestamp) {
        this.eventID = eventID;
        this.ticker = ticker;
        this.timestamp = timestamp;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventID() {
        return this.eventID;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getTicker() {
        return this.ticker;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String toString() {
        return "Event [eventID=" + eventID + ", ticker=" + ticker + ", timestamp=" + timestamp + "]";
    }
}
