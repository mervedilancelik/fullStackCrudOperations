package com.example.etiyaprojectbe.service;
import com.example.etiyaprojectbe.entity.TicketType;

import java.util.List;

public interface TicketTypeService{

    TicketType createTicketType(TicketType ticketType);

    TicketType updateTicketType(TicketType ticketType);

    void deleteTicketType(TicketType ticketType);

    List<TicketType> listTicketType();


}
