package com.example.proiect.Events;

import com.example.proiect.model.Client;
import com.example.proiect.model.Event;
import com.example.proiect.repository.ClientRepository;
import com.example.proiect.repository.EventRepository;
import com.example.proiect.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientTests {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private EventService eventService;

    @Test
    void create() {
        //arrange
        Client client = new Client("Tudi", "Andrei", 100);
//        when(ClientRepository.findClientByName(client.getNume()))
//                .thenReturn(Optional.empty());
        Client savedClient = new Client (4, "Tudi", "Andrei", 100);
        when(clientRepository.save(client)).thenReturn(savedClient);

        //act
        Client result = eventService.saveNewClient(client);

        //assert
        assertNotNull(result);
        assertEquals(savedClient.getClientId(), result.getClientId());
        assertEquals(savedClient.getNume(), result.getNume());
        assertEquals(savedClient.getPrenume(), result.getPrenume());
        assertEquals(savedClient.getCash(), result.getCash());

//        verify(eventRepository).findByEmail(event.getEventStart());
//        verify(eventRepository).save(client);
    }
}
