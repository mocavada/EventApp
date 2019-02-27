package com.mocavada.fullstack.service;

import com.mocavada.fullstack.entity.Event;
import com.mocavada.fullstack.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class EventService implements IEventService {

    @Autowired
    private IEventRepository eventRepository;

    @Override
    public void createEvent(Event event) {
        eventRepository.createEvent(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }


}


