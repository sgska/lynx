package com.example.android.lynx.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EventsWrapper {
    private List<Event> events;
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
