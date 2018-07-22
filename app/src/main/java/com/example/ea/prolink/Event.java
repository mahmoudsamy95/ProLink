package com.example.ea.prolink;

/**
 * Created by mahmoud on 7/5/2018.
 */

public class Event {
    String event_name,event_place,event_desc,event_duration,event_day,event_month;

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_place() {
        return event_place;
    }

    public void setEvent_place(String event_place) {
        this.event_place = event_place;
    }

    public String getEvent_desc() {
        return event_desc;
    }

    public void setEvent_desc(String event_desc) {
        this.event_desc = event_desc;
    }

    public String getEvent_duration() {
        return event_duration;
    }

    public void setEvent_duration(String event_duration) {
        this.event_duration = event_duration;
    }

    public String getEvent_day() {
        return event_day;
    }

    public void setEvent_day(String event_day) {
        this.event_day = event_day;
    }

    public String getEvent_month() {
        return event_month;
    }

    public void setEvent_month(String event_month) {
        this.event_month = event_month;
    }

    public Event(String event_name,String event_place,String event_desc,String event_duration,String event_day,String event_month) {

        this.event_name = event_name;
        this.event_place = event_place;
        this.event_desc = event_desc;
        this.event_duration = event_duration;
        this.event_day = event_day;
        this.event_month = event_month;
    }
}
