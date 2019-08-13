package com.enjoywith.enjoywith.dao.repository;

import com.enjoywith.enjoywith.dao.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {
    Event findEventById(int id);
}
