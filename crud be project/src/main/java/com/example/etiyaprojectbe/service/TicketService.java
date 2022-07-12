package com.example.etiyaprojectbe.service;

import com.example.etiyaprojectbe.entity.Ticket;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TicketService {
    Ticket createTicket(Ticket ticket);

    Ticket updateTicket(Ticket ticket);

    void deleteTicket(Ticket ticket);

    List<Ticket> listTicket();

    Ticket listTicketId(int id);


}
