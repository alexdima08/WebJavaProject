package com.example.proiect.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    @NotBlank(message = "eventName must not be null")
    private String eventName;
    @NotBlank(message = "eventStart must not be null")
    private String eventStart;
    @Min(value = 80, message = "eventPrice should be greater than 80")
    private float eventPrice;

    @OneToOne
    @JoinColumn(name = "event_details_id")
    private EventDetails eventDetails;

    @ManyToMany()
    @JoinTable(name = "schedule", joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name="location_id"))
    private List<Location> locationList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "ticket", joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name="client_id"))
    private List<Client> clientList = new ArrayList<>();


    public Event(){

    }

    public Event(String eventName, String eventStart, float eventPrice) {
        this.eventName = eventName;
        this.eventStart = eventStart;
        this.eventPrice = eventPrice;
    }

    public Event(int eventId, String eventName, String eventStart, float eventPrice) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventStart = eventStart;
        this.eventPrice = eventPrice;
    }
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventStart() {
        return eventStart;
    }

    public void setEventStart(String eventStart) {
        this.eventStart = eventStart;
    }

    public float getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(float eventPrice) {
        this.eventPrice = eventPrice;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

}
