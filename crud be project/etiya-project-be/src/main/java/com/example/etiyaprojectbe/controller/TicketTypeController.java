package com.example.etiyaprojectbe.controller;

import com.example.etiyaprojectbe.entity.TicketType;
import com.example.etiyaprojectbe.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Dış dünyadan gelen ticketType  isteklerini karşılayan sınıf
 */

@RestController
@RequestMapping("/api/ticketType")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = "*")
public class TicketTypeController {

    @Autowired
    TicketTypeService ticketTypeService;

    /**
     * TicketType listeleme isteklerini karşılayan motod
     *
     * @return dönen değer ticketType listesi
     */

    @GetMapping("/list")
    public List<TicketType> getAllTicketType() {
        return ticketTypeService.listTicketType();
    }

    /**
     * TicketType oluşturma isteklerini karşılayan motod
     *
     * @param ticketType
     * @return dönen değer yaratılan ticketType nesnesi
     */


    @PostMapping("/create")
    public TicketType create(@RequestBody TicketType ticketType) {

        return ticketTypeService.createTicketType(ticketType);
    }

    /**
     * TicketType güncelleme isteklerini karşılayan motod
     *
     * @param ticketType
     * @return dönen değer güncellenen ticketType nesnesi
     */

    @PostMapping("/update")
    public TicketType update(@RequestBody TicketType ticketType) {
        return ticketTypeService.updateTicketType(ticketType);
    }

    /**
     * TicketType'ın silinme isteklerini karşılayan motod
     *
     * @param ticketType
     */

    @PostMapping("/delete")
    public void delete(@RequestBody TicketType ticketType) {

        ticketTypeService.deleteTicketType(ticketType);
    }


}
