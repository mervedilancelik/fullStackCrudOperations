package com.example.etiyaprojectbe.repository;

import com.example.etiyaprojectbe.entity.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketTypeRepository extends JpaRepository<TicketType,Integer> {
}
