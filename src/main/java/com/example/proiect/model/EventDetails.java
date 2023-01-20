package com.example.proiect.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "event_details")
public class EventDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventDetailsId;
    @NotBlank(message = "description must not be null")

    private String description;

    public EventDetails(){

    }

    public int getEventDetailsId() {
        return eventDetailsId;
    }

    public void setEventDetailsId(int eventDetailsId) {
        this.eventDetailsId = eventDetailsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
