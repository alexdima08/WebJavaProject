package com.example.proiect.controler;

import com.example.proiect.model.Client;
import com.example.proiect.model.Event;
import com.example.proiect.model.EventDetails;
import com.example.proiect.model.Location;
import com.example.proiect.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventControler {

    private final EventService eventService;

    public EventControler(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/client/new")
    public ResponseEntity<Client> saveClient(@Valid @RequestBody Client client) {
        return ResponseEntity.ok()
                .body(eventService.saveNewClient(client));
    }

    @PostMapping("/eventDetails/new")
    public ResponseEntity<EventDetails> saveEventDetails(@Valid @RequestBody EventDetails eventDetails) {
        return ResponseEntity.ok()
                .body(eventService.saveEventDetails(eventDetails));
    }

    @PostMapping("/location/new")
    public ResponseEntity<Location> saveEventDetails(@Valid @RequestBody Location location) {
        return ResponseEntity.ok()
                .body(eventService.saveLocation(location));
    }

    @PostMapping("/event/new")
    public ResponseEntity<Event> saveEvent(@Valid @RequestBody Event event,
                                           @RequestParam List<Integer> clientIds,
                                           @RequestParam List<Integer> locationIds,
                                           @RequestParam int eventDetailsId) {
        return ResponseEntity.ok()
                .body(eventService.saveEvent(event, clientIds, locationIds, eventDetailsId));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Event>> retrieveEvents() {
        return ResponseEntity.ok()
                .body(eventService.retrieveEvents());
    }

}
