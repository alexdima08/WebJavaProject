package com.example.proiect.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;
    @NotBlank(message = "Nume must not be null")
    private String nume;
    @NotBlank(message = "Prenume must not be null")
    private String prenume;
    @Min(value = 100, message = "cash should be greater than 100")
    private int cash;

    @ManyToMany
    @JsonIgnore
    private List<Event> eventList = new ArrayList<>();

    public Client(){

    }

    public Client(int clientId, String nume, String prenume, int cash) {
        this.clientId = clientId;
        this.nume = nume;
        this.prenume = prenume;
        this.cash = cash;
    }

    public Client(String nume, String prenume, int cash) {
        this.nume = nume;
        this.prenume = prenume;
        this.cash = cash;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }


}
