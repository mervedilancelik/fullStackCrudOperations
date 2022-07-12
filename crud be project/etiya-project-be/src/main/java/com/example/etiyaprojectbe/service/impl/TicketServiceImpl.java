package com.example.etiyaprojectbe.service.impl;

import com.example.etiyaprojectbe.entity.Ticket;
import com.example.etiyaprojectbe.exception.ResourceNotFoundException;
import com.example.etiyaprojectbe.repository.TicketRepository;
import com.example.etiyaprojectbe.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Ticketlar ile ilgili süreçlerin  yönetildiği sınıf
 */

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    /**
     * Ticketların yartıldığı metod
     *
     * @param ticket
     * @return dönen değer yaratılan ticket nesnesi
     */

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    /**
     * Ticketların güncellendiği metod
     *
     * @param ticket
     * @return dönen değer güncellenen ticket nesnesi
     */
    @Override
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);

    }

    /**
     * Ticketların silindiği metod
     *
     * @param ticket
     */

    @Override
    public void deleteTicket(Ticket ticket) {
        ticketRepository.delete(ticket);
    }

    /**
     * Tüm Ticketların listelendiği method
     *
     * @return dönen değer ticketların listesi
     */

    @Override
    public List<Ticket> listTicket() {

        return ticketRepository.findAll();

    }

    /**
     * Ticketları id bilgisine göre  listeleyen motod
     *
     * @param id
     * @return dönen değer id değerine göre listelenen ticket nesnesi
     */

    @Override
    public Ticket listTicketId(int id) {
        Optional<Ticket> result = ticketRepository.findById(id);

        Ticket ticket;

        if (result.isPresent()) {
            ticket = result.get();
        } else {

            throw new ResourceNotFoundException("Ticket bulunamadı" + id);
        }
        return ticket;

    }

}
