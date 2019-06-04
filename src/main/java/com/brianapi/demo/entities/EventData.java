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

    @GeneratedValue
    @Id
    private long id;

    @NotNull
    @Positive
    private long millisSinceEpoch;

    @NotNull
    @Positive
    private long userId;

    // consider making this enum?
    @NotNull
    @Pattern(regexp = "click|impression", message = "event field must be match one of the following: click, impression")
    private String event;

    public EventData() {}

    public EventData(long millisSinceEpoch, long userId, String event) {
        this.millisSinceEpoch = millisSinceEpoch;
        this.userId = userId;
        this.event = event;
    }

    public long getMillis_since_epoch() {
        return millisSinceEpoch;
    }

    public void setMillis_since_epoch(long millisSinceEpoch) {
        this.millisSinceEpoch = millisSinceEpoch;
    }

    public long getUser_id() {
        return userId;
    }

    public void setUser_id(long user_id) {
        this.userId = user_id;
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
                "millisSinceEpoch=" + millisSinceEpoch +
                ", userId=" + userId +
                ", event=" + event +
                '}';
    }
}
