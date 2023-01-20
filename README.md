# WebJavaProject, Event Organization

## This is a Java Spring Boot application that can make transactions for differrent types of events. There is a Client determined by
>clientId, nume, prenume, cash.
## He is able to buy a ticket to an existing Event, determined by
> eventId, eventName, eventStart, eventPrice. 
## Each event has a description and a location where it is going to take place:.
> locationId, country, city
##  I created a Ticket and Schedule entity in order to manage all the clients that want to participate at an event on a location. 

## ***This aplication will have the following main bussiness requirements:***

### 1) To be able to add Clients

### 2) To be able to add EventDescriptions

### 3) To be able to add Locations

### 4) To be able to add Events

### 5) To be able to make all conections of the tables

### 6) To be able to see all the events

### 7) To stop the client to buy a ticket if his provided cash isn't enough to buy the ticket

### 8) To stop the client to buy a ticket to an already finished event

### 9) To give the client a small refound when he is attending to an Event

### 10) To create a checklist of each client

## ***The aplication current main features are:***

### 1) To be able to add Clients

### 2) To be able to add EventDescriptions

### 3) To be able to add Locations

### 4) To be able to add Events

### 5) To be able to make all conections of the tables

### 6) To be able to see all the events

## ***Functionalities of the app***

### By accesing the route ```localhost:8080/events/client/new``` a user can create a client in the database. This is a post request.
### By accesing the route ```localhost:8080/events/location/new``` a user can create a ocation in the database. This is a post request.
### By accesing the route ```localhost:8080/events/eventDetails/new``` a user can create a description of an event in the data base. This is a post request.
### By accesing the route ```localhost:8080/events/event/new?clientIds=clientId&locationIds=locationId&eventDetailsId=eventDetailsId``` a user can create a event in the data base. It can also create the conections to other tables(if we say clientIds = 1, locationIds= 1, eventDetailsId = 1 means that on the current event the Client1 wants to attend it at Location1 and the event has EventDescription1). This is a post request.
### By accesing the route ```localhost:8080/events/list``` we can see all the events that are created, with locations, descriptions and the clients that are attending. This is a get request


