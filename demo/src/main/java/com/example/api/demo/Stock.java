package com.example.api.demo;

import org.json.JSONArray;
import org.json.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;



public class Stock {
    private Event event;
    private String name;
    private Day[] days;

    public Stock() {}

    public Stock(String request) throws JsonProcessingException {
        JSONObject jsonObject = new JSONObject(request);
        JSONObject jsonEventObject = jsonObject.getJSONObject("event");
        JSONArray jsonArray = jsonObject.getJSONArray("days");
        
        this.event = new Event(jsonEventObject.getString("eventID"), jsonEventObject.getString("ticker"), jsonEventObject.getString("timestamp"));
        this.name = jsonObject.getString("name");
        this.days = new Day[jsonArray.length()];

        int i = 0;
        for(Object eachDay : jsonArray) {
            if (eachDay instanceof JSONObject) {
                JSONObject day = (JSONObject) eachDay;
                this.days[i++] = new Day(day.getString("date"), day.getDouble("open"), day.getDouble("close"), day.getDouble("high"), day.getDouble("low"), day.getDouble("totalMovement"), day.getDouble("direction"), day.getString("state"), day.getDouble("pLowerWick"), day.getDouble("pBody"), day.getDouble("pUpperWick"));
            }
        }
    }

    public Stock(Event event, String name, Day[] days) {
        this.event = event;
        this.name = name;
        this.days = days;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setName(String name) {
        this.event = event;
    }

    public String getName() {
        return this.name;
    }

    public void setDays(Day[] days) {
        this.days = days;
    }

    public Day[] getDays() {
        return this.days;
    }

    @Override
    public String toString() {
        return "Stock [event=" + event.toString() + ", name=" + name + ", days=" + days.toString() + "]";
    }
}
