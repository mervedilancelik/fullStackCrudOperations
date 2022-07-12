package com.example.etiyaprojectbe.service.impl;

import com.example.etiyaprojectbe.entity.TicketType;
import com.example.etiyaprojectbe.repository.TicketTypeRepository;
import com.example.etiyaprojectbe.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TicketType ile ilgili süreçlerin  yönetildiği sınıf
 */

@Service
public class TicketTypeServiceImpl implements TicketTypeService {

    @Autowired
    TicketTypeRepository ticketTypeRepository;

    /**
     * TicketTypeların yartıldığı metod
     *
     * @param ticketType
     * @return dönen değer yaratılan ticketType nesnesi
     */

    @Override
    public TicketType createTicketType(TicketType ticketType) {
        return ticketTypeRepository.save(ticketType);
    }

    /**
     * TicketTypeların güncellendiği metod
     *
     * @param ticketType
     * @return dönen değer güncellenen ticketType nesnesi
     */

    @Override
    public TicketType updateTicketType(TicketType ticketType) {
        return ticketTypeRepository.save(ticketType);
    }

    /**
     * TicketTypeların silindiği metod
     *
     * @param ticketType
     */

    @Override
    public void deleteTicketType(TicketType ticketType) {
        ticketTypeRepository.delete(ticketType);
    }

    /**
     * Tüm ticketTypeların listelendiği method
     *
     * @return dönen değer ticketType listesi
     */

    @Override
    public List<TicketType> listTicketType() {
        return ticketTypeRepository.findAll();
    }
}
