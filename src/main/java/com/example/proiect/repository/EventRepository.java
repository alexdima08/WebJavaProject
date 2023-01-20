package com.example.proiect.repository;

import com.example.proiect.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findEventByEventName(String name);
}
