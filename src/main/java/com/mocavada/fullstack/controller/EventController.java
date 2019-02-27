package com.mocavada.fullstack.controller;


import com.mocavada.fullstack.entity.Event;
import com.mocavada.fullstack.service.IEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/event" )
public class EventController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IEventService eventService;

    @PostMapping("/create")
    public ResponseEntity<Void> createEvent(@RequestBody Event event, UriComponentsBuilder builder) {

        eventService.createEvent(event);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/all").buildAndExpand(event.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {

        List<Event> le = eventService.getAllEvents();

        return new ResponseEntity<List<Event>>(le,HttpStatus.OK);
    }


}
