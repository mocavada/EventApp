package com.mocavada.fullstack.repository;

import com.mocavada.fullstack.entity.Event;

import java.util.List;

public interface IEventRepository {
    void createEvent(Event event);
    List<Event> getAllEvents();
}
