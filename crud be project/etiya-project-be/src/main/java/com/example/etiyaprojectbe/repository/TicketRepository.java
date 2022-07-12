package com.example.etiyaprojectbe.repository;


import com.example.etiyaprojectbe.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {





}
