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

    @Autowired
    private IEventService eventService;

//    @Autowired
//    private TestService testService;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<Void> createEvent(@RequestBody Event event, UriComponentsBuilder builder) {

        eventService.createEvent(event);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/create").buildAndExpand(event.getId()).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity<List<Event>> getAllEvents() {

        List<Event> le = eventService.getAllEvents();

        return new ResponseEntity<List<Event>>(le,HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/all")
//    public List<Event> listAllAndSort() {
//
//        return this.testService.getEventList();
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/create")
////    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
//    @ResponseStatus(HttpStatus.CREATED)
//    public @ResponseBody
//    List<Event> createJob(@RequestBody Event event) {
//        Event newEvent = this.testService.postEvent(event);
//        return this.testService.getEventList();
//    }


}
