package com.mocavada.fullstack.service;

import com.mocavada.fullstack.entity.Event;

import java.util.List;

public interface IEventService {
    void createEvent(Event event);
    List<Event> getAllEvents();
}
