package com.brianapi.demo.entities;

import com.brianapi.demo.utils.Event;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
public class EventData {

    @Id
    @NotNull
    @Positive
    private long millis_since_epoch;

    @NotNull
    @Positive
    private long user_id;

    // consider making this enum?
    @NotNull
    @Pattern(regexp = "click|impression", message = "event field must be match one of the following: click, impression")
    private String event;

    public EventData() {}

    public EventData(long millis_since_epoch, long user_id, String event) {
        this.millis_since_epoch = millis_since_epoch;
        this.user_id = user_id;
        this.event = event;
    }

    public long getMillis_since_epoch() {
        return millis_since_epoch;
    }

    public void setMillis_since_epoch(long millis_since_epoch) {
        this.millis_since_epoch = millis_since_epoch;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "EventData{" +
                "millis_since_epoch=" + millis_since_epoch +
                ", user_id=" + user_id +
                ", event=" + event +
                '}';
    }
}
