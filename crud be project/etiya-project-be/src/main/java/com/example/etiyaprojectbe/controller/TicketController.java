package com.example.etiyaprojectbe.controller;
import com.example.etiyaprojectbe.entity.Ticket;
import com.example.etiyaprojectbe.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Dış dünyadan gelen ticket isteklerini karşılayan sınıf
 */

@RestController
@RequestMapping(value = "/api/ticket")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST}, allowedHeaders = "*")
public class TicketController {


    @Autowired
    private TicketService ticketService;

    /**
     * Ticket listeleme isteklerini karşılayan motod
     * @return dönen değer ticketların listesi
     */

    @GetMapping("/list")
    public List<Ticket> getAllTicket() {
        return ticketService.listTicket();
    }

    /**
     * Ticket oluşturma isteklerini karşılayan motod
     * @param ticket
     * @return dönen değer yaratılan ticket nesnesi
     */

    @PostMapping("/create")
    public Ticket create(@RequestBody Ticket ticket) {

        return ticketService.createTicket(ticket);
    }

    /**
     * Ticket güncelleme isteklerini karşılayan motod
     * @param ticket
     * @return dönen değer güncellenen ticket nesnesi
     */

    @PostMapping("/update")
    public Ticket update(@RequestBody Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

    /**
     * Ticket silme isteklerini karşılayan motod
     * @param ticket
     */
    @PostMapping("/delete")
    public void delete(@RequestBody Ticket ticket) {
        ticketService.deleteTicket(ticket);
    }

    /**
     * Ticketın id bilgisine göre  listeleme isteklerini karşılayan motod
     * @param id
     * @return dönen değer id değerine göre listelenen ticket nesnesi
     */
    @GetMapping(value = "/list/{id}")
    public Ticket getTicketById(@PathVariable int id) {
        return ticketService.listTicketId(id);
    }

}
