package com.example.api.demo;

// Employee entity class

import java.awt.geom.Arc2D;

public class Day {
    private String date;
    private Double open; 
    private Double close;
    private Double high;
    private Double low;
    private Double totalMovement;
    private Double direction;
    private String state;
    private Double pLowerWick;
    private Double pBody;
    private Double pUpperWick;

    public Day() {}
    public Day(String date, Double open, Double close, Double high, Double low, Double totalMovement, Double direction, String state, Double pLowerWick, Double pBody, Double pUpperWick) {
        this.date = date;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.totalMovement = totalMovement;
        this.direction = direction;
        this.state = state;
        this.pLowerWick = pLowerWick;
        this.pBody = pBody;
        this.pUpperWick = pUpperWick;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getOpen() {
        return this.open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return this.close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getHigh() {
        return this.high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return this.low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getTotalMovement() {
        return this.totalMovement;
    }

    public void setTotalMovement(Double totalMovement) {
        this.totalMovement = totalMovement;
    }

    public Double getDirection() {
        return this.direction;
    }

    public void setDirection(Double date) {
        this.direction = direction;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getPLowerWick() {
        return this.pLowerWick;
    }

    public void setPLowerWick(Double pLowerWick) {
        this.pLowerWick = pLowerWick;
    }

    public Double getPBody() {
        return this.pBody;
    }

    public void setPBody(Double pBody) {
        this.pBody = pBody;
    }

    public Double getPUpperWick() {
        return this.pUpperWick;
    }

    public void setPUpperWick(Double pUpperWick) {
        this.pUpperWick = pUpperWick;
    }

    public void updateState() {
        if(this.direction < 0)
            this.state = "Bearish";
    }

    

    @Override
    public String toString() {
        return "Day [date=" + date + ", open=" + open + ", close=" + close + ", high=" + high + ", low=" + low +
        ", totalMovement=" + totalMovement + ", direction=" + direction + ", state=" + state + 
        ", pLowerWick=" + pLowerWick + ", pBody=" + pBody + ", pUpperWick=" + pUpperWick + "]";
    }
}
