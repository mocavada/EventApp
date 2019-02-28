//package com.mocavada.fullstack.service;
//
//
//import com.mocavada.fullstack.entity.Event;
//import com.mocavada.fullstack.repository.TestRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class TestService {
//
//    @Autowired
//    private TestRepository testRepository;
//
//    public TestService(TestRepository testRepository) {
//        this.testRepository = testRepository;
//    }
//
//    //create
//    public Event postEvent(Event event) {
//        return this.testRepository.save(event);
//    }
//
//    //read
//    public List<Event> getEventList() {
//        List<Event> list = new ArrayList<>();
//        testRepository.findAll(new Sort(Sort.Direction.DESC, "dateCreated")).forEach(list::add);
//
//        return list;
//    }
//
//
//
//
//
//}
