package com.brianapi.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TimestampData {

    @Id
    long id;
    long timestamp;
    int uniqueUsers;
    int clicks;
    int impressions;

    public TimestampData(long timestamp, int uniqueUsers, int clicks, int impressions) {
        this.timestamp = timestamp;
        this.uniqueUsers = uniqueUsers;
        this.clicks = clicks;
        this.impressions = impressions;
    }

    public TimestampData(){}

    public int getUniqueUsers() {
        return uniqueUsers;
    }

    public void setUniqueUsers(int uniqueUsers) {
        this.uniqueUsers = uniqueUsers;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getImpressions() {
        return impressions;
    }

    public void setImpressions(int impressions) {
        this.impressions = impressions;
    }
}
