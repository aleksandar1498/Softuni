package com.enjoywith.enjoywith.services;

import com.enjoywith.enjoywith.dao.entities.Event;
import com.enjoywith.enjoywith.dao.repository.EventRepository;
import com.enjoywith.enjoywith.interfaces.Addable;
import com.enjoywith.enjoywith.interfaces.BaseAddable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService extends BaseAddable<Event> {
    // we pass to the superclass the concrete type of repos
    public EventService(EventRepository eventRepository) {
        super(eventRepository);
    }

    public void findEvent(int id) {
        ((EventRepository) super.getRepository()).findEventById(1);
    }

    public void save(Event event) {
        super.getRepository().save(event);
    }
}
