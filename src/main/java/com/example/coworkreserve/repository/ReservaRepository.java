package com.example.coworkreserve.repository;

import com.example.coworkreserve.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
