package com.example.proiect.service;

import com.example.proiect.model.Client;
import com.example.proiect.model.Event;
import com.example.proiect.model.EventDetails;
import com.example.proiect.model.Location;
import com.example.proiect.repository.ClientRepository;
import com.example.proiect.repository.EventDetailsRepository;
import com.example.proiect.repository.EventRepository;
import com.example.proiect.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class EventService {

    private final EventRepository eventRepository;
    private final EventDetailsRepository eventDetailsRepository;
    private final ClientRepository clientRepository;
    private final LocationRepository locationRepository;

    public EventService(EventRepository eventRepository, EventDetailsRepository eventDetailsRepository, ClientRepository clientRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.eventDetailsRepository = eventDetailsRepository;
        this.clientRepository = clientRepository;
        this.locationRepository = locationRepository;
    }

    public Client saveNewClient(Client client) {
        return clientRepository.save(client);
    }

    public EventDetails saveEventDetails(EventDetails eventDetails) {
        return eventDetailsRepository.save(eventDetails);
    }

    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    public Event saveEvent(Event event, List<Integer> clientIds, List<Integer> locationIds, int eventDetailsId) {
        EventDetails eventDetails = eventDetailsRepository.findById(eventDetailsId)
                .orElseThrow(() -> new RuntimeException("EventDetailsId is not valid!!"));
        event.setEventDetails(eventDetails);

        List<Client> clients = clientRepository.findAllById(clientIds);
        List<Location> locations = locationRepository.findAllById(locationIds);
        event.setClientList(clients);
        event.setLocationList(locations);

        return eventRepository.save(event);
    }

    public List<Event> retrieveEvents() {
        return eventRepository.findAll();
    }


}
