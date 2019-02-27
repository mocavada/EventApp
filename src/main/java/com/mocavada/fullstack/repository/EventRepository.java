package com.mocavada.fullstack.repository;


import com.mocavada.fullstack.entity.Event;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Repository
public class EventRepository implements IEventRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createEvent(Event event) {
        entityManager.persist(event);
    }

    @Override
    public List<Event> getAllEvents() {

        String jpql = "select e from Event e order by e.id";

        return  (List<Event>) entityManager.createQuery(jpql).getResultStream().collect(Collectors.toList());

    }
}
